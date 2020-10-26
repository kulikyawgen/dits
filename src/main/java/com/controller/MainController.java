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

    private final TopicService topicService;
    private final TestService testService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    @Autowired
    public MainController(TopicService topicService, TestService testService, QuestionService questionService, AnswerService answerService) {
        this.topicService = topicService;
        this.testService = testService;
        this.questionService = questionService;
        this.answerService = answerService;
    }


    @GetMapping("/user")
    public String getIndexPage() {
       return "user/indexUser";
    }

    @GetMapping("/user/topics")
    public String getTopics(Model model){
        model.addAttribute("topics",topicService.getPage(0,7,"ASC","name"));
        return "user/topicsUser";
    }

    @GetMapping("/user/tests/{id}")
    public String getTests(Model model, @PathVariable int id){
        model.addAttribute("test",testService.getByTopic(id,0,7,"ASC","name"));
        return "user/preTestUser";
    }

    @GetMapping("/user/test/{id}")
    public String preStartPage(Model model, @PathVariable int id){
        Test test = testService.getOne(id);
        Topic topic = topicService.getOne(test.getTopic().getTopicId());
        model.addAttribute("test", test);
        model.addAttribute("topic", topic);
        return "/user/testStart";
    }
    @GetMapping("/user/test_run/{id}/{quest_num}")
    public String questionsForTest(Model model, @PathVariable int id,@PathVariable int quest_num){
        Test test = testService.getOne(id);
        List<Answer> answers;
        try {
            answers = answerService.getAllAnswersByQuestionId(test.getQuestions().get(quest_num).getQuestionId());
        }catch (IndexOutOfBoundsException exception){
            return "/user/finish";
        }
        model.addAttribute("test",test);
        model.addAttribute("question",test.getQuestions().get(quest_num));
        model.addAttribute("answers",answers);
        model.addAttribute("numOfQuestion",quest_num);
        return "/user/runningTest";
    }
}