package com.controller.question;

import com.model.Question;
import com.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("{id}")
    public ModelAndView getOne(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("question");
        mav.addObject("question", questionService.getOne(id));
        return mav;
    }

    @GetMapping
    public ModelAndView getPage(@RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "7") int size,
                                @RequestParam(required = false, defaultValue = "ASC") String order,
                                @RequestParam(required = false, defaultValue = "name") String... params) {
        ModelAndView mav = new ModelAndView("question");
        mav.addObject("questions", questionService.getPage(page, size, order, params));
        return mav;
    }

    @GetMapping("/test")
    public ModelAndView getByTests(
            @RequestParam int id,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "7") int size,
            @RequestParam(required = false, defaultValue = "ASC") String order,
            @RequestParam(required = false, defaultValue = "name") String... params) {
        ModelAndView mav = new ModelAndView("question");
        mav.addObject("questions", questionService.getByTest(id, page, size, order, params));
        return mav;
    }


    @PostMapping
    public ModelAndView create(@RequestBody Question question) {
        ModelAndView mav = new ModelAndView("question");
        mav.addObject("newQuestion", questionService.create(question));
        return mav;
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestBody Question question) {
        ModelAndView mav = new ModelAndView("question");
        mav.addObject("updatedQuestion", questionService.update(question));
        return mav;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        questionService.deleteById(id);
        return "question";
    }
}