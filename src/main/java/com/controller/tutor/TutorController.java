package com.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutor")
public class TutorController {

    @GetMapping(value = "/test")
    public String addTest(){
        return "/tutor/addTest";
    }

    @GetMapping("/question")
    public String addQuestion(){
        return "/tutor/addQuestion";
    }

}
