package com.coding404.myWeb;

import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.product.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCode01 {
    @Autowired
    ProductMapper productMapper;

//    @Test
//    public void insertTest() {
//        for (int i = 1; i <= 100; i++) {
//            ProductVO vo = ProductVO.builder()
//                    .prodEndDate("2024-10-15")
//                    .prodWriter("admin")
//                    .prodName("test" + i)
//                    .prodPrice((i * 100)+"")
//                    .prodCount((i * 10)+"")
//                    .prodDiscount(i+"")
//                    .prodPurchaseYn("Y")
//                    .prodContent("test" + i)
//                    .prodComment("test" + i)
//                    .build();
//            productMapper.regist(vo);
//        }
//    }

}
