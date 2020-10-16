package com.controller;

import com.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//This controller for testing your services. You can change it how you need.

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public ModelAndView getWelcome(@RequestParam(required = false, defaultValue = "0") int page,
                                   @RequestParam(required = false, defaultValue = "7") int size,
                                   @RequestParam(required = false, defaultValue = "ASC") String order,
                                   @RequestParam(required = false, defaultValue = "name") String... params) {
        ModelAndView mav = new ModelAndView("we");
        mav.addObject("topics", topicService.getPage(page, size, order, params).getContent());
        return mav;
    }
}