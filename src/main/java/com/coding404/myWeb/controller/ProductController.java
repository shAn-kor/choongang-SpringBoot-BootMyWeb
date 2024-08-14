package com.coding404.myWeb.controller;

import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.product.ProductService;
import com.coding404.myWeb.util.Criteria;
import com.coding404.myWeb.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

//    @GetMapping("/productList")
//    public String productList(Model model, Criteria criteria) {
//        System.out.println(criteria.toString());
//
//        // 현재 로그인되어있는 사람 아이디가 admin 이라고 가정
//        String userId = "admin";
//        List<ProductVO> list = productService.getProductList(userId, criteria);
//        model.addAttribute("list", list);
//
//        // 페이지VO
//        int total = productService.getTotal(userId);
//        PageVO pageVO = new PageVO(criteria, total);
//        model.addAttribute("pageVO", pageVO);
//
//        return "product/productList";
//    }

    // 1. criteria 같은 객체에 검색 키워드 추가
    // 2. 목록sql, total sql 둘다 동적쿼리로 변경
    // 3. 화면에서 사용자가 검색버튼을 누를때, 다시 page 번호를 1번으로, amount를 10으로
    // 4. 검색값 유지 (criteria 안에 있음)
    // 5. 페이지네이션 누를 시, 검색 키워드를 같이 넘겨줘야 한다.
    // 6. 100씩 보기버튼 처리
    @GetMapping("/productList")
    public String productList(Model model, @ModelAttribute("criteria")Criteria criteria) {
        System.out.println(criteria.toString());

        // 현재 로그인되어있는 사람 아이디가 admin 이라고 가정
        String userId = "admin";
        List<ProductVO> list = productService.getProductList(userId, criteria);
        model.addAttribute("list", list);

        // 페이지VO
        int total = productService.getTotal(userId, criteria);
        PageVO pageVO = new PageVO(criteria, total);
        model.addAttribute("pageVO", pageVO);

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
