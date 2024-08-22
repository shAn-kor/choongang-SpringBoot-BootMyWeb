package com.coding404.myWeb.controller;

import com.coding404.myWeb.command.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/loginForm")
    public String loginForm(UserVO vo, HttpSession session) {
        UserVO userVO = vo;

        if (userVO == null) {
            return "redirect:user/login";
        }
        session.setAttribute("user", userVO);
        return "redirect:/";
    }
}
