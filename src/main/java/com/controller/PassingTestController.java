/*
@author Andrei Gorevoi
*/
package com.controller;

import com.dto.QuestionDto;
import com.model.Question;
import com.model.Statistic;
import com.model.Test;
import com.service.answer.AnswerService;
import com.service.statistic.StatisticService;
import com.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/passing")
public class PassingTestController {

    private final TestService testService;
    private final AnswerService answerService;
    private final StatisticService statisticService;

    @Autowired
    public PassingTestController(TestService testService, AnswerService answerService, StatisticService statisticService) {
        this.testService = testService;
        this.answerService = answerService;
        this.statisticService = statisticService;
    }


}
