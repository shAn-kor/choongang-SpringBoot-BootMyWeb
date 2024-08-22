package com.coding404.myWeb.notice;

import com.coding404.myWeb.command.NoticeVO;
import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.util.Criteria;

import java.util.List;

public interface NoticeService {
    List<ProductVO> getNoticeNullProductList(String userId);

    List<NoticeVO> getNoticeList(String id, Criteria criteria);

    void inputNotice(NoticeVO noticeVO);

    NoticeVO getNotice(String noticeId);

    int getTotal(String id, Criteria criteria);
}
