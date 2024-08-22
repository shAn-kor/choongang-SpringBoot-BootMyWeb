package com.coding404.myWeb.controller;

import com.coding404.myWeb.command.NoticeVO;
import com.coding404.myWeb.command.UserVO;
import com.coding404.myWeb.notice.NoticeService;
import com.coding404.myWeb.util.Criteria;
import com.coding404.myWeb.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/noticeReg")
    public String noticeReg(Model model, HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        String userId = user.getId();

        model.addAttribute("prodList", noticeService.getNoticeNullProductList(userId));
        return "notice/noticeReg";
    }

    @PostMapping("/noticeRegForm")
    public String noticeRegForm(NoticeVO noticeVO) {
        System.out.println(noticeVO.toString());

        noticeService.inputNotice(noticeVO);

        return "redirect:/notice/noticeList";
    }

    @GetMapping("/noticeDetail")
    public String noticeDetail(@RequestParam("noticeId") String noticeId, Model model) {
        NoticeVO noticeVO = noticeService.getNotice(noticeId);

        model.addAttribute("noticeVO", noticeVO);

        return "notice/noticeDetail";
    }

    @RequestMapping("/noticeList")
    public String noticeList(Model model, @ModelAttribute("criteria") Criteria criteria, HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        String id = user.getId();
        List<NoticeVO> list = noticeService.getNoticeList(id, criteria);
        model.addAttribute("noticeList", list);

        int total = noticeService.getTotal(id, criteria);
        PageVO pageVO = new PageVO(criteria, total);
        model.addAttribute("pageVO", pageVO);

        return "notice/noticeList";
    }
}
