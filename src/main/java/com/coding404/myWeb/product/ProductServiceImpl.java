package com.coding404.myWeb.product;

import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductVO> getProductList(String userId, Criteria criteria) {
        return productMapper.getProductList(userId, criteria);
    }

    @Override
    public int registProduct(ProductVO productVO) {
        return productMapper.regist(productVO);
    }

    @Override
    public ProductVO getProductDetail(Integer prodId) {
        return productMapper.getProduct(prodId);
    }

    @Override
    public void updateProduct(ProductVO productVO) {
        productMapper.updateProduct(productVO);
    }

    @Override
    public void deleteProduct(Integer prodId) {
        productMapper.deleteProduct(prodId);
    }
}
