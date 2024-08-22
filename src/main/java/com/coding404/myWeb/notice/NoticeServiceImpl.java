package com.coding404.myWeb.notice;

import com.coding404.myWeb.command.NoticeVO;
import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.util.Criteria;
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

    @Override
    public List<NoticeVO> getNoticeList(String id, Criteria criteria) {
        return noticeMapper.getNoticeList(id, criteria);
    }

    @Override
    public void inputNotice(NoticeVO noticeVO) {
        noticeMapper.insertNotice(noticeVO);
    }

    @Override
    public NoticeVO getNotice(String noticeId) {
        return noticeMapper.getNotice(noticeId);
    }

    @Override
    public int getTotal(String id, Criteria criteria) {
        return noticeMapper.getTotal(id, criteria);
    }
}
