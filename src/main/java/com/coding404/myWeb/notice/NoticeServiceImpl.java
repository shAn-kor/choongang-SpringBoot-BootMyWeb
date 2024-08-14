package com.coding404.myWeb.notice;

import com.coding404.myWeb.command.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public List<ProductVO> getNoticeNullProductList(String userId) {
        return noticeMapper.getNoticeNullProductList(userId);
    }
}
