package com.controller.admin;

import com.dto.StatisticDto;
import com.model.Role;
import com.model.Test;
import com.model.User;
import com.service.role.RoleService;
import com.service.test.TestService;
import com.service.topic.TopicService;
import com.service.user.UserService;
import com.service.statistic.statisticDto.StatisticDtoService;
import com.validator.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("userRegistrationValidator")
    private UserRegistrationValidator userRegistrationValidator;

    @Autowired
    private StatisticDtoService statisticDtoService;

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
    public String createUser(@ModelAttribute @Validated User user,
                             BindingResult bindingResult,
                             @RequestParam("role") ArrayList<String> role) {
        userRegistrationValidator.validate(user, bindingResult);
        System.out.println(role);
        if (bindingResult.hasErrors()) {
            return "admin/createUser";
        } else {
            List<Role> roles = role.stream()
                    .map(s -> roleServiceImp.findByName(s))
                    .collect(Collectors.toList());

            user.setRoles(roles);
            userServiceImp.addUser(user);
        }
        return "redirect:/admin";
    }

    @GetMapping("/createTest")
    public String createTest(Model model) {
        model.addAttribute("topics", topicServiceImp.getAll());
        model.addAttribute("tests", testRepository.getAllTests());
        return "admin/createTest";
    }

    @PostMapping("/createTest")
 public String createTest(
            @RequestParam String topic,
            @RequestParam String nameTest,
            @RequestParam String descriptionTest
   ) {
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
        List<StatisticDto> listToView = statisticDtoService.getUserTestStatisticList();
        model.addAttribute("listToView", listToView);
        return "/admin/statistics/usersStatistic";
    }

    @GetMapping("/statistic/questionStatistic")
    public String questionStatistic(Model model) {
        List<StatisticDto> questionStatisticList = statisticDtoService.getQuestionStatisticList();
        model.addAttribute("statistics", questionStatisticList);
        return "/admin/statistics/questionStatistic";
    }

    @GetMapping("/statistic/testStatistic")
    public String testStatistic(Model model) {
        List<StatisticDto> testStatisticList = statisticDtoService.getTestStatisticList();
        model.addAttribute("testStat", testStatisticList);
        return "/admin/statistics/testStatistic";
    }
}