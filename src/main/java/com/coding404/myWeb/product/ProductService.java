package com.coding404.myWeb.product;

import com.coding404.myWeb.command.CategoryVO;
import com.coding404.myWeb.command.ProductUploadVO;
import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.util.Criteria;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductVO> getProductList(String userId, Criteria criteria);
    int getTotal(String userId, Criteria criteria); // 특정 관리자의 모든 게시글

    int registProduct(ProductVO productVO, List<MultipartFile> files);

    ProductVO getProductDetail(Integer prodId);

    void updateProduct(ProductVO productVO);

    void deleteProduct(Integer prodId);

    List<CategoryVO> getCategory();

    List<CategoryVO> getCategoryChild(CategoryVO vo);

    List<ProductUploadVO> getImgs(Integer prodId);
}
