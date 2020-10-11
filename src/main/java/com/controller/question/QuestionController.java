package com.controller.question;

import com.model.Question;
import com.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("{id}")
    public Model getOne(@PathVariable int id, Model model) {
        return model.addAttribute("question", questionService.getOne(id));
    }

    @GetMapping
    public Model getPage(Model model,
                         @RequestParam(required = false, defaultValue = "0") int page,
                         @RequestParam(required = false, defaultValue = "7") int size,
                         @RequestParam(required = false, defaultValue = "ASC") String order,
                         @RequestParam(required = false, defaultValue = "name") String... params) {
        return model.addAttribute("questions", questionService.getPage(page, size, order, params));
    }

    @GetMapping("/test")
    public Model getByTests(Model model,
                            @RequestParam int id,
                            @RequestParam(required = false, defaultValue = "0") int page,
                            @RequestParam(required = false, defaultValue = "7") int size,
                            @RequestParam(required = false, defaultValue = "ASC") String order,
                            @RequestParam(required = false, defaultValue = "name") String... params) {
        return model.addAttribute("questions", questionService.getByTest(id, page, size, order, params));
    }


    @PostMapping
    public Model create(@RequestBody Question question, Model model) {
        return model.addAttribute("newQuestion", questionService.create(question));
    }

    @PatchMapping
    public Model update(@RequestBody Question question, Model model) {
        return model.addAttribute("updatedQuestion", questionService.update(question));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        questionService.deleteById(id);
    }
}