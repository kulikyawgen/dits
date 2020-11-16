package com.controller;

import com.model.Answer;
import com.model.Test;
import com.model.Topic;
import com.model.User;
import com.service.answer.AnswerService;
import com.service.question.QuestionService;
import com.service.test.TestService;
import com.service.topic.TopicService;
import com.service.user.UserService;
import com.service.user.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final TestService testService;
    private final AnswerService answerService;

    @Autowired
    public MainController(TopicService topicService, TestService testService, QuestionService questionService, AnswerService answerService) {
        this.testService = testService;
        this.answerService = answerService;
    }


    @GetMapping("/")
    public String getIndexPage() {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if(authorities.size()==1){
            switch (authorities.get(0).getAuthority()){
                case "ROLE_USER":
                    return "/user/indexUser";
                case "ROLE_ADMIN":
                    return "redirect:/admin";
                case "ROLE_TUTOR":
                    return "/tutor";
            }
        }
        if(authorities.size()==2){
            int user =0;
            int tutor=0;
            int admin=0;
            for (GrantedAuthority authority : authorities) {
                if(authority.getAuthority().equals("ROLE_USER")){
                    user=1;
                }else if(authority.getAuthority().equals("ROLE_TUTOR")){
                    tutor=1;
                }else if(authority.getAuthority().equals("ROLE_ADMIN")){
                    admin=1;
                }
            }
            if(user==1 && tutor==1){
                return "/indexUserTutor";
            }else if(user==1 && admin==1){
                return "/indexAdminUser";
            }else {
                return "/tutorAdmin";
            }
        }
        if(authorities.size()==3){
            return "/indexAll";
        }

        return null;

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