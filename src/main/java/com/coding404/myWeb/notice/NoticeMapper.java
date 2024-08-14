package com.coding404.myWeb.notice;

import com.coding404.myWeb.command.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<ProductVO> getNoticeNullProductList(String userId);
}
