package com.coding404.myWeb.controller;

import com.coding404.myWeb.notice.NoticeService;
import com.mysql.cj.protocol.x.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/noticeReg")
    public String noticeReg(Model model) {
        String userId = "admin";

        model.addAttribute("prodList", noticeService.getNoticeNullProductList(userId));
        return "notice/noticeReg";
    }

    @GetMapping("/noticeDetail")
    public String noticeDetail(Model model) {
        return "notice/noticeDetail";
    }

    @RequestMapping("/noticeList")
    public String noticeList() {
        return "notice/noticeList";
    }
}
