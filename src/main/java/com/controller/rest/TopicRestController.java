package com.controller.rest;

import com.model.Topic;
import com.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/topic")
public class TopicRestController {

    @Autowired
    private TopicService topicService;

    @GetMapping("{id}")
    public Topic getOne(@PathVariable int id) {
        return topicService.getOne(id);
    }

    @GetMapping
    public Page<Topic> getPage(@RequestParam(required = false, defaultValue = "0") int page,
                               @RequestParam(required = false, defaultValue = "7") int size,
                               @RequestParam(required = false, defaultValue = "ASC") String order,
                               @RequestParam(required = false, defaultValue = "name") String... params) {
        return topicService.getPage(page, size, order, params);
    }

    @PostMapping
    public Topic create(@RequestBody Topic topic) {
        return topicService.create(topic);
    }
}