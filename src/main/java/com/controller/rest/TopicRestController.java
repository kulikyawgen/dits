package com.controller.rest;

import com.dto.TopicDto;
import com.service.topic.TopicDtoServiceDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
public class TopicRestController {

    @Autowired
    private TopicDtoServiceDecorator topicService;

    @GetMapping
    public Page<TopicDto> getPage(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "7") int size,
                                  @RequestParam(required = false, defaultValue = "ASC") String order,
                                  @RequestParam(required = false, defaultValue = "name") String... params) {
        return topicService.getPage(page, size, order, params);
    }
}