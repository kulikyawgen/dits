package com.controller.staticstic;

import com.model.*;
import com.service.link.LinkService;
import com.service.literature.LiteratureService;
import com.service.statistic.StatisticService;
import com.service.test.TestService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    private final LiteratureService literatureService;
    private final LinkService linkService;
    private final UserService userService;
    private final PersonalStatisticService personalStatisticService;

    @Autowired
    public StatisticController(StatisticService statisticService, LiteratureService literatureService,
                               LinkService linkService, UserService userService,
                               TestService testService, PersonalStatisticService personalStatisticService) {
        this.personalStatisticService = personalStatisticService;
        this.literatureService = literatureService;
        this.linkService = linkService;
        this.userService = userService;
    }

    @GetMapping
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

    /**
     *
     * @param model
     * @return
     *
     * Данный метод принимает дату прохождения конкретного теста и передает на view модель статистики
     * с информацией о прохождении теста залогированным юзером;
     */
    @GetMapping("/test/final")
    public String getStatistic(Model model, HttpSession session){
//        TODO userId security
        List<Statistic> statistics = (List<Statistic>) session.getAttribute("statistics");
        List<PersonalStatisticByTest> statisticView = new ArrayList<>();
        int numOfCorrect=0;
//        Fill list of statisticView (Name of question, is correct, list of literature, list of links)
        for (Statistic statistic : statistics) {
            PersonalStatisticByTest pst = new PersonalStatisticByTest();
            pst.setNameOfQuestion(statistic.getQuestion().getDescription());
            pst.setCorrect(statistic.isCorrect());
            List<Literature> allLiteratureByQuestionId = literatureService.getAllLiteratureByQuestionId(statistic.getQuestion().getQuestionId());
            List<Link> allLinks = new ArrayList<>();
            for (Literature literature : allLiteratureByQuestionId) {
                allLinks.addAll(linkService.getAllLinkByLiteratureId(literature.getLiteratureId()));
            }
            pst.setLiterature(allLiteratureByQuestionId);
            pst.setLinkToLiterature(allLinks);
            if(statistic.isCorrect()){
                numOfCorrect++;
            }
            statisticView.add(pst);
        }

        model.addAttribute("statistics",statisticView);
        model.addAttribute("percent",Math.round(((double)numOfCorrect/statistics.size()) *100));
        model.addAttribute("numOfCorrect",numOfCorrect);
        model.addAttribute("numOfQuestion",statistics.size());
        session.removeAttribute("statistics");
        return "/user/userStatistic/testStatistic";
    }


    /**
     *
     * @param model
     * @return
     *
     * Данный метод передает на view статистику для каждого пройденого теста для зологированного
     * юзера;
     */
    @GetMapping("/users")
    public String statisticByUser(Model model){
        model.addAttribute("statistics",personalStatisticService.getPersonalStatistic());
        return "/user/userStatistic/userStatistic";
    }



}

