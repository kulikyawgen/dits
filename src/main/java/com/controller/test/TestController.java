package com.controller.test;

import com.model.Test;
import com.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("{id}")
    public ModelAndView getOne(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("test", testService.getOne(id));
        return mav;
    }

    @GetMapping
    public ModelAndView getPage(@RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "7") int size,
                                @RequestParam(required = false, defaultValue = "ASC") String order,
                                @RequestParam(required = false, defaultValue = "name") String... params) {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("tests", testService.getPage(page, size, order, params));
        return mav;
    }

    @GetMapping("/topic")
    public ModelAndView findByTopic(@RequestParam int id,
                                    @RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "7") int size,
                                    @RequestParam(required = false, defaultValue = "ASC") String order,
                                    @RequestParam(required = false, defaultValue = "name") String... params) {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("tests", testService.getByTopic(id, page, size, order, params));
        return mav;
    }

    @GetMapping("/all")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("testsEdit");
        mav.addObject("tests", testService.getPage(0, 100, "ASC", "testId").getContent());
        return mav;
    }

    @GetMapping("/topic/all")
    public ModelAndView findAllByTopic(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("tests", testService.getByTopic(id, 0, 100, "ASC", "test_id").getContent());
        return mav;
    }

    @PostMapping
    public ModelAndView create(@RequestBody Test test) {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("newTest", testService.create(test));
        return mav;
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestBody Test test) {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("updatedTest", testService.update(test));
        return mav;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        testService.deleteById(id);
        return "test";
    }
}