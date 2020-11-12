package com.controller.staticstic;

import com.model.Question;
import com.model.Statistic;
import com.model.Test;
import com.model.ViewStatistic;
import com.service.question.QuestionServiceImpl;
import com.service.statistic.StatisticServiceImpl;
import com.service.user.UserServiceImp;
import com.service.viewStatistic.ViewStatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private ViewStatisticServiceImpl viewStatisticService;


    @GetMapping
    public String statisticPage() {
        return "statistics/statistic";
    }

    @GetMapping("/usersStatistic")
    public String usersStatistic(Model model) {
        return "statistics/usersStatistic";
    }

    @GetMapping("/questionStatistic")
    public String questionStatistic(Model model) {
        List<ViewStatistic> questionStatisticList = viewStatisticService.getQuestionStatisticList();
        model.addAttribute("statistics", questionStatisticList);
        return "statistics/questionStatistic";
    }

    @GetMapping("/testStatistic")
    public String testStatistic(Model model) {
        List<ViewStatistic> testStatisticList = viewStatisticService.getTestStatisticList();
        model.addAttribute("testStat", testStatisticList);
        return "statistics/testStatistic";
    }
}

