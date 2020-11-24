package com.controller.admin;

import com.model.Test;
import com.model.User;
import com.model.ViewStatistic;
import com.repository.test.TestRepository;
import com.repository.topic.TopicRepository;
import com.service.role.RoleService;
import com.service.test.TestService;
import com.service.topic.TopicService;
import com.service.user.UserService;
import com.service.viewStatistic.ViewStatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
//    TODO соблюсти принцип DI!!!
    @Autowired
    private ViewStatisticServiceImpl viewStatisticService;

    @Autowired
    private UserService userServiceImp;

    @Autowired
    private RoleService roleServiceImp;

    @Autowired
    private TopicService topicServiceImp;

    @Autowired
    private TestService testRepository;


    @GetMapping()
    public String welcomeAdmin() {
        return "admin/indexAdmin";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("allRoles", roleServiceImp.getAllRole());
        return "admin/createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        userServiceImp.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/createTest")
    public String createTest(Model model) {
        model.addAttribute("topics", topicServiceImp.getAll());
        model.addAttribute("tests", testRepository.getAllTests());
        return "admin/createTest";
    }
//TODO написать документацию для всех методов
    @PostMapping("/createTest")
    public String createTest(@RequestParam String topic,
                             @RequestParam String nameTest,
                             @RequestParam String descriptionTest) {
//        TODO не работает код
        Test newTest = new Test();
        newTest.setName(nameTest);
        newTest.setDescription(descriptionTest);
        newTest.setTopic(topicServiceImp.getByName(topic));
        System.out.println(newTest);
        testRepository.create(newTest);
        return "redirect:/admin";
    }

    @GetMapping("/statistic")
    public String getStatisticPage() {
        return "admin/statistics/statistic";
    }

    @GetMapping("/statistic/usersStatistic")
    public String usersStatistic(Model model) {
        List<ViewStatistic> listToView = viewStatisticService.getUserTestStatisticList();
        model.addAttribute("listToView", listToView);
        return "/admin/statistics/usersStatistic";
    }

    @GetMapping("/statistic/questionStatistic")
    public String questionStatistic(Model model) {
        List<ViewStatistic> questionStatisticList = viewStatisticService.getQuestionStatisticList();
        model.addAttribute("statistics", questionStatisticList);
        return "/admin/statistics/questionStatistic";
    }

    @GetMapping("/statistic/testStatistic")
    public String testStatistic(Model model) {
        List<ViewStatistic> testStatisticList = viewStatisticService.getTestStatisticList();
        model.addAttribute("testStat", testStatisticList);
        return "/admin/statistics/testStatistic";
    }


}