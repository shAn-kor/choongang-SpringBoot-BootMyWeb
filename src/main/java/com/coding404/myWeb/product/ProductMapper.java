package com.coding404.myWeb.product;

import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    int regist(ProductVO productVO);

    List<ProductVO> getProductList(@Param("prodWriter")String prodWriter, @Param("cri")Criteria criteria); // 목록 (매개변수가 2개 이상이면, 이름을 붙인다)

    ProductVO getProduct(Integer prodId);

    void updateProduct(ProductVO productVO);

    void deleteProduct(Integer prodId);
}
