package com.coding404.myWeb.notice;

import com.coding404.myWeb.command.NoticeVO;
import com.coding404.myWeb.command.ProductVO;
import com.coding404.myWeb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<ProductVO> getNoticeNullProductList(String userId);

    List<NoticeVO> getNoticeList(@Param("id") String id, @Param("cri") Criteria criteria);

    void insertNotice(NoticeVO noticeVO);

    NoticeVO getNotice(String noticeId);

    int getTotal(@Param("id") String id, @Param("cri") Criteria criteria);
}
