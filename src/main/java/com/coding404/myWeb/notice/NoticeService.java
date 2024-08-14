package com.coding404.myWeb.notice;

import com.coding404.myWeb.command.ProductVO;

import java.util.List;

public interface NoticeService {
    List<ProductVO> getNoticeNullProductList(String userId);
}
