package com.controller.topic;

import com.model.Topic;
import com.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("{id}")
    public Model getOne(@PathVariable int id, Model model) {
        return model.addAttribute("topic", topicService.getOne(id));
    }

    @GetMapping
    public Model getPage(Model model,
                         @RequestParam(required = false, defaultValue = "0") int page,
                         @RequestParam(required = false, defaultValue = "7") int size,
                         @RequestParam(required = false, defaultValue = "ASC") String order,
                         @RequestParam(required = false, defaultValue = "name") String... params) {
        return model.addAttribute("topics", topicService.getPage(page, size, order, params));
    }

    @PostMapping
    public Model create(@RequestBody Topic topic, Model model) {
        return model.addAttribute("newTopic", topicService.create(topic));
    }

    @PatchMapping
    public Model update(@RequestBody Topic topic, Model model) {
        return model.addAttribute("updatedTopic", topicService.update(topic));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        topicService.deleteById(id);
    }
}