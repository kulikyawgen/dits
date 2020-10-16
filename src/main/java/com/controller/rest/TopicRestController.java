package com.controller.rest;

import com.dto.TopicDto;
import com.service.topic.TopicDtoServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/topic")
public class TopicRestController {

    @Autowired
    private TopicDtoServiceWrapper topicDtoService;

    @GetMapping("{id}")
    public TopicDto getOne(@PathVariable int id) {
        return topicDtoService.getOne(id);
    }

    @GetMapping
    public Page<TopicDto> getPage(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "7") int size,
                                  @RequestParam(required = false, defaultValue = "ASC") String order,
                                  @RequestParam(required = false, defaultValue = "name") String... params) {
        return topicDtoService.getPage(page, size, order, params);
    }

    @PostMapping
    public TopicDto create(@RequestBody TopicDto topicDto) {
        return topicDtoService.create(topicDto);
    }

    @PatchMapping
    public TopicDto update(@RequestBody TopicDto topicDto) {
        return topicDtoService.update(topicDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        topicDtoService.deleteById(id);
    }
}