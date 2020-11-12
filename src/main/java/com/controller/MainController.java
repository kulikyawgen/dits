package com.controller;

import com.model.Answer;
import com.model.Test;
import com.model.Topic;
import com.service.answer.AnswerService;
import com.service.question.QuestionService;
import com.service.test.TestService;
import com.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final TestService testService;
    private final AnswerService answerService;

    @Autowired
    public MainController(TopicService topicService, TestService testService, QuestionService questionService, AnswerService answerService) {
        this.testService = testService;
        this.answerService = answerService;
    }


    @GetMapping("/")
    public String getIndexPage() {
       return "/user/indexUser";
    }

    @GetMapping("/user/test_run/{id}/{quest_num}")
    public String questionsForTest(Model model, @PathVariable int id,@PathVariable int quest_num){
        Test test = testService.getOne(id);
        List<Answer> answers;
        try {
            answers = answerService.getAllAnswersByQuestionId(test.getQuestions().get(quest_num).getQuestionId());
        }catch (IndexOutOfBoundsException exception){
            return "/user/passingTest/finish";
        }
        model.addAttribute("test",test);
        model.addAttribute("question",test.getQuestions().get(quest_num));
        model.addAttribute("answers",answers);
        model.addAttribute("numOfQuestion",quest_num);
        return "/user/passingTest/runningTest";
    }
}