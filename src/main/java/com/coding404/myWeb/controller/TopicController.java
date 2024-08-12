package com.coding404.myWeb.controller;

import com.coding404.myWeb.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topicDetail")
    public String topicDetail() {
        return "topic/topicDetail";
    }

    @RequestMapping("/topicListAll")
    public String topicListAll() {
        return "topic/topicListAll";
    }

    @RequestMapping("/topicListMe")
    public String topicListMe() {
        return "topic/topicListMe";
    }

    @RequestMapping("/topicModify")
    public String topicModify() {
        return "topic/topicModify";
    }

    @RequestMapping("/topicReg")
    public String topicReg() {
        return "topic/topicReg";
    }
}
