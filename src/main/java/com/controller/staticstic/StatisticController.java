package com.controller.staticstic;

import com.service.link.LinkService;
import com.service.literature.LiteratureService;
import com.service.statistic.PersonalStatisticServiceImpl;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    private final LiteratureService literatureService;
    private final LinkService linkService;
    private final UserService userService;
    private final PersonalStatisticServiceImpl personalStatisticServiceImpl;

    @Autowired
    public StatisticController(LiteratureService literatureService,
                               LinkService linkService, UserService userService,
                               PersonalStatisticServiceImpl personalStatisticServiceImpl) {
        this.personalStatisticServiceImpl = personalStatisticServiceImpl;
        this.literatureService = literatureService;
        this.linkService = linkService;
        this.userService = userService;
    }

    @GetMapping()
    public String statisticPage(){
        return "statistics/statistic" ;
    }


    @GetMapping("/usersStatistic")
    public String usersStatistic(Model model) {
        model.addAttribute("users", userService.getAllUser());
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

