package com.controller.topic;

import com.model.Topic;
import com.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("{id}")
    public ModelAndView getOne(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("topic/topics_select");
        mav.addObject("topic", topicService.getOne(id));
        return mav;
    }

    @GetMapping
    public ModelAndView getPage(@RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "7") int size,
                                @RequestParam(required = false, defaultValue = "ASC") String order,
                                @RequestParam(required = false, defaultValue = "name") String... params) {
        ModelAndView mav = new ModelAndView("topic/topics_select");
        mav.addObject("topics", topicService.getPage(page, size, order, params));
        return mav;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("topics",topicService.getPage(0,7,"ASC","name").getContent());
        return "/passingTest/topicsUser";
    }


    @PostMapping
    public ModelAndView create(@RequestBody Topic topic) {
        ModelAndView mav = new ModelAndView("topic/topics_select");
        mav.addObject("newTopic", topicService.create(topic));
        return mav;
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestBody Topic topic) {
        ModelAndView mav = new ModelAndView("topic/topics_select");
        mav.addObject("updatedTopic", topicService.update(topic));
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        topicService.deleteById(id);
        return "topic/topics_select";
    }
}