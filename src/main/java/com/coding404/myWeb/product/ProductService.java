package com.coding404.myWeb.product;

import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.util.Criteria;

import java.util.List;

public interface ProductService {
    List<ProductVO> getProductList(String userId, Criteria criteria);

    int registProduct(ProductVO productVO);

    ProductVO getProductDetail(Integer prodId);

    void updateProduct(ProductVO productVO);

    void deleteProduct(Integer prodId);
}
