package com.coding404.myWeb.controller;

import com.coding404.myWeb.command.CategoryVO;
import com.coding404.myWeb.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AjaxController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getCategory")
    public ResponseEntity<List<CategoryVO>> getCategory() {
        List<CategoryVO> list = productService.getCategory();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 2단, 3단 카테고리
    @GetMapping("/getCategoryChild/{groupId}/{categoryLv}/{categoryDetailLv}")
    public ResponseEntity<List<CategoryVO>> getCategoryChild(
            @PathVariable("groupId") String groupId,
            @PathVariable("categoryLv") int categoryLv,
            @PathVariable("categoryDetailLv") int categoryDetailLv
    ) {
        CategoryVO vo = CategoryVO.builder()
                .group_id(groupId)
                .category_lv(categoryLv)
                .category_detail_lv(categoryDetailLv)
                .build();

        List<CategoryVO> list = productService.getCategoryChild(vo);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
