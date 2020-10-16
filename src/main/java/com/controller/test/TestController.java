package com.controller.test;

import com.model.Test;
import com.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("{id}")
    public Model getOne(@PathVariable int id, Model model) {
        return model.addAttribute("test", testService.getOne(id));
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
    public Model findByTopic(Model model,
                             @RequestParam int id,
                             @RequestParam(required = false, defaultValue = "0") int page,
                             @RequestParam(required = false, defaultValue = "7") int size,
                             @RequestParam(required = false, defaultValue = "ASC") String order,
                             @RequestParam(required = false, defaultValue = "name") String... params) {
        return model.addAttribute("tests", testService.getByTopic(id, page, size, order, params));
    }

    @PostMapping
    public Model create(@RequestBody Test test, Model model) {
        return model.addAttribute("newTest", testService.create(test));
    }

    @PostMapping("/update")
    public Model update(@RequestBody Test test, Model model) {
        return model.addAttribute(testService.update(test));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        testService.deleteById(id);
    }
}