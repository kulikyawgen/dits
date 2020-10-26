package com.controller.admin;

import com.model.Role;
import com.model.Test;
import com.model.Topic;
import com.model.User;
import com.repository.question.QuestionRepository;
import com.repository.test.TestRepository;
import com.repository.topic.TopicRepository;
import com.service.role.RoleServiceImp;
import com.service.user.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private RoleServiceImp roleServiceImp;

    @Autowired
    private TopicRepository topicServiceImp; //временно

    @Autowired
    private TestRepository testRepository; // временно

    @Autowired
    private QuestionRepository questionRepository;// временно

    @GetMapping()
    public String welcomeAdmin() {
        return "admin/welcomeAdmin";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("allRoles", roleServiceImp.getAllRole());
        return "admin/createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(Arrays.asList(roleServiceImp.findByName("USER")));
//        System.out.println(user.getRoles());
        userServiceImp.addUser(newUser);
        return "redirect:/admin";
    }

    @GetMapping("/createTest")
    public String createTest(Model model) {
        model.addAttribute("topics", topicServiceImp.findAll());
        model.addAttribute("tests", testRepository.findAll());
        // model.addAttribute("questions", questionRepository.findAll());
        return "admin/createTest";
    }

    @PostMapping("/createTest")
    public String createTest(@RequestParam String topic,
                             @RequestParam String nameTest,
                             @RequestParam String descriptionTest) {
        Test newTest = new Test();
        newTest.setName(nameTest);
        newTest.setDescription(descriptionTest);
        newTest.setTopic(topicServiceImp.findByName(topic));
        System.out.println(newTest);
//        testRepository.save(newTest);
        return "redirect:/admin";
    }

    @GetMapping("/statistic")
    public String getStatisticPage(){
   //     model.addAttribute("role", role);
        return "statistics/statistic";
    }
}