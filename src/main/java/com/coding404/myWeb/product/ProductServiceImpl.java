package com.coding404.myWeb.product;

import com.coding404.myWeb.command.CategoryVO;
import com.coding404.myWeb.command.ProductUploadVO;
import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Value("${project.uploadPath}")
    private String uploadPath;

    @Override
    public List<ProductVO> getProductList(String userId, Criteria criteria) {
        return productMapper.getProductList(userId, criteria);
    }

    @Override
    public int getTotal(String userId, Criteria criteria) {
        return productMapper.getTotal(userId, criteria);
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 이 메서드 안에서 예외 발생 시 rollback 시킴
    // 단 try~catch 문장으로 예외처리가 되면, 트랜잭션 처리가 되지 않는다.
    public int registProduct(ProductVO productVO, List<MultipartFile> files) {
        int result = productMapper.regist(productVO);
        // 파일 업로드 처리
        // 파일 경로 insert
        // 상품데이터 insert
        for (MultipartFile file : files) {
            String originName = file.getOriginalFilename();
            String fileName = originName.substring(originName.lastIndexOf("\\") + 1);
            String filePath = makeFolder();
            String uuid = UUID.randomUUID().toString();
            String savePath = uploadPath + filePath + uuid + "_" + fileName;
            try {
                file.transferTo(new File(savePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ProductUploadVO vo = ProductUploadVO
                    .builder()
                    .filepath(filePath)
                    .filename(fileName)
                    .uuid(uuid)
                    .prodWriter(productVO.getProdWriter())
                    .build();
            productMapper.uploadFile(vo);
        }
        return result;
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

    @Override
    public List<CategoryVO> getCategory() {
        return productMapper.getCategory();
    }

    @Override
    public List<CategoryVO> getCategoryChild(CategoryVO vo) {
        return productMapper.getCategoryChild(vo);
    }

    @Override
    public List<ProductUploadVO> getImgs(Integer prodId) {
        return productMapper.getImgs(prodId);
    }

    // 폴더 생성 함수
    private String makeFolder() {
        String filepath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM"));

        File file = new File(uploadPath + filepath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return filepath + "/";
    }
}
