package com.coding404.myWeb.controller;

import com.coding404.myWeb.command.CategoryVO;
import com.coding404.myWeb.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
public class AjaxController {
    @Autowired
    private ProductService productService;

    @Value("${project.uploadPath}")
    String uploadPath;

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

    // 이미지 데이터 응답 대한 요청
//    @GetMapping("/display/{filepath}/{uuid}/{filename}")
//    public byte[] display(
//            @PathVariable("filepath") String filepath,
//            @PathVariable("uuid") String uuid,
//            @PathVariable("filename") String filename
//    ) {
//        // 하드디스크 파일 경로
//        byte[] result = null;
//
//        String path = uploadPath + filepath + "/" + uuid + "_" + filename;
//        File file = new File(path);
//
//        try {
//            result = FileCopyUtils.copyToByteArray(file); // 파일 데이터의 BYTE 배열값을 구해 반환
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return result;
//    }
    // ResponseEntity를 이용해 이미지 응답문서 작성
    @GetMapping("/display/{filepath}/{uuid}/{filename}")
    public ResponseEntity<byte[]> display(
            @PathVariable("filepath") String filepath,
            @PathVariable("uuid") String uuid,
            @PathVariable("filename") String filename
    ) {
        // 하드디스크 파일 경로
        byte[] result = null;

        String path = uploadPath + filepath + "/" + uuid + "_" + filename;
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();

        try {
            result = FileCopyUtils.copyToByteArray(file); // 파일 데이터의 BYTE 배열값을 구해 반환
            headers.add("Content-Type", Files.probeContentType(file.toPath())); // 해당 경로 파일의 mime 타입 구함
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }

    @GetMapping("/download/{filepath}/{uuid}/{filename}")
    public ResponseEntity<byte[]> download(
            @PathVariable("filepath") String filepath,
            @PathVariable("uuid") String uuid,
            @PathVariable("filename") String filename
    ) {
        // 하드디스크 파일 경로
        byte[] result = null;

        String path = uploadPath + filepath + "/" + uuid + "_" + filename;
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();

        try {
            headers.add("Content-Disposition", "attachment; filename=" + filename); // 해당 경로 파일의 mime 타입 구함
            result = FileCopyUtils.copyToByteArray(file); // 파일 데이터의 BYTE 배열값을 구해 반환
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }
}
