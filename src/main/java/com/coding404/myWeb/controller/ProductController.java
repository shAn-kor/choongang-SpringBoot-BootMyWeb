package com.coding404.myWeb.controller;

import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.product.ProductService;
import com.coding404.myWeb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping("/productReg")
    public String productReg() {
        return "product/productReg";
    }

    @PostMapping("/productRegForm")
    public String productRegForm(ProductVO productVO, RedirectAttributes redirectAttributes) {
        System.out.println(productVO.toString());

        int num = productService.registProduct(productVO);

        if (num > 0) {
            redirectAttributes.addAttribute("msg", "정상 등록되었습니다.");
        } else {
            redirectAttributes.addAttribute("msg", "등록을 실패했습니다.");
        }

        return "redirect:/product/productList";
    }

    @GetMapping("/productList")
    public String productList(Model model, Criteria criteria) {
        System.out.println(criteria.toString());

        // 현재 로그인되어있는 사람 아이디가 admin 이라고 가정
        String userId = "admin";
        model.addAttribute("list", productService.getProductList(userId, criteria));

        return "product/productList";
    }

    @GetMapping("/productDetail")
    public String productDetail(@RequestParam("prodId") Integer prodId, Model model) {
        model.addAttribute("vo", productService.getProductDetail(prodId));
        return "product/productDetail";
    }

    @PostMapping("/productUpdate")
    public String productUpdate(ProductVO productVO, RedirectAttributes redirectAttributes) {
        productService.updateProduct(productVO);

        redirectAttributes.addAttribute("prodId", productVO.getProdId());

        return "redirect:/product/productDetail";
    }

    @PostMapping("/productDelete")
    public String productDelete(@RequestParam("prodId") Integer prodId, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(prodId);
        return "redirect:/product/productList";
    }
}
