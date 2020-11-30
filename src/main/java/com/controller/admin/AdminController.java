package com.controller.admin;

import com.model.StatisticViewForAdmin;
import com.dto.TestDto;
import com.mapper.TestMapper;
import com.model.Role;
import com.model.User;
import com.service.role.RoleService;
import com.service.test.TestService;
import com.service.topic.TopicService;
import com.service.user.UserService;
import com.service.statistic.StatisticViewForAdminService;
import com.validator.TestFormValidator;
import com.validator.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRegistrationValidator userRegistrationValidator;

    @Autowired
    private TestFormValidator testFormValidator;

    @Autowired
    private StatisticViewForAdminService statisticDtoService;

    @Autowired
    private UserService userServiceImp;

    @Autowired
    private RoleService roleServiceImp;

    @Autowired
    private TopicService topicServiceImp;

    @Autowired
    private TestService testService;
    @Autowired
    private TestMapper testMapper;

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
        if (bindingResult.hasErrors()) {
            //TODO Разобраться здесь, может нужно в модель ложить что бы после return были заполнены поля формы регистрации
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
        model.addAttribute("tests", testService.getAllTests());
        return "admin/createTest";
    }
//TODO написать документацию для всех методов
    @PostMapping("/createTest")
    public String createTest(
            @ModelAttribute @Validated TestDto test,
            BindingResult bindingResult) {
        testFormValidator.validate(test, bindingResult);
        if (bindingResult.hasErrors()) {
            //TODO Разобраться здесь, может нужно в модель ложить что бы после return были заполнены поля формы регистрации
            return "admin/createTest";
        } else {
            testService.create(testMapper.toTest(test));
        }
        return "redirect:/admin";
    }

    @GetMapping("/statistic")
    public String getStatisticPage() {
        return "admin/statistics/statistic";
    }

    @GetMapping("/statistic/usersStatistic")
    public String usersStatistic(Model model) {
        List<StatisticViewForAdmin> listToView = statisticDtoService.getUserTestStatisticList();
        model.addAttribute("listToView", listToView);
        return "/admin/statistics/usersStatistic";
    }

    @GetMapping("/statistic/questionStatistic")
    public String questionStatistic(Model model) {
        List<StatisticViewForAdmin> questionStatisticList = statisticDtoService.getQuestionStatisticList();
        model.addAttribute("statistics", questionStatisticList);
        return "/admin/statistics/questionStatistic";
    }

    @GetMapping("/statistic/testStatistic")
    public String testStatistic(Model model) {
        List<StatisticViewForAdmin> testStatisticList = statisticDtoService.getTestStatisticList();
        model.addAttribute("testStat", testStatisticList);
        return "/admin/statistics/testStatistic";
    }
}