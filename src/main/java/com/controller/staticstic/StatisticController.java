package com.controller.staticstic;

import com.service.user.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping
    public String statisticPage(){return "statistics/statistic" ;   }


    @GetMapping("/usersStatistic")
    public String usersStatistic(Model model) {
        model.addAttribute("users", userServiceImp.getAllUser());
        return "statistics/usersStatistic";
    }

    @GetMapping("/questionStatistic")
    public String questionStatistic(Model model){
        return "statistics/questionStatistic";
    }

    @GetMapping("/testStatistic")
    public String testStatistic(Model model){
        return "statistics/testStatistic";
    }
}

