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

import java.util.*;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;
    private final LiteratureService literatureService;
    private final LinkService linkService;
    private final UserService userService;
    private final TestService testService;

    @Autowired
    public StatisticController(StatisticService statisticService, LiteratureService literatureService, LinkService linkService, UserService userService, TestService testService) {
        this.statisticService = statisticService;
        this.literatureService = literatureService;
        this.linkService = linkService;
        this.userService = userService;
        this.testService = testService;
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

    @GetMapping("/type")
    public String typeOfStatistic(){
        return "/userStatistic/typeOfStatistic";
    }

    /**
     *
     * @param userId
     * @param model
     * @return
     *
     * Метод передает на view мапу с датой прохождения теста и сам тест.
     */
    @GetMapping("/{userId}")
    public String testsByUserId(@PathVariable int userId, Model model){
        List<Statistic> statistics = statisticService.getStatisticByUserIdGroupByDate(userId);
        Map<Date,Test> tests= new HashMap<>();
        for (Statistic statistic : statistics) {
            tests.put(statistic.getDate(),statistic.getQuestion().getTest());
        }
        model.addAttribute("tests", tests);
        return "/userStatistic/testSelect";
    }

    /**
     *
     * @param date
     * @param model
     * @return
     *
     * Данный метод принимает дату прохождения конкретного теста и передает на view модель статистики
     * с информацией о прохождении теста залогированным юзером;
     */
    @GetMapping("/test/{date}")
    public String getStatistic(@PathVariable long date,
                               Model model){
//        TODO userId security
        List<Statistic> statistics = statisticService.getStatisticsByDateAndUserId(new Date(date), 21);
        List<PersonalStatisticByTest> statisticView = new ArrayList<>();
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
            statisticView.add(pst);
        }
        model.addAttribute("statistics",statisticView);
        return "/userStatistic/testStatistic";
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
//        Достаю все сгруппированные статистики для конкретного пользователя
//        TODO userId from security
        List<Statistic> statisticsGroupByDate = statisticService.getStatisticByUserIdGroupByDate(21);
//        Создаю лист в котором будут лежать итоговые статистики для каждого теста
        List<PersonalStatisticForUser> psu = new ArrayList<>();
//        Пробегаю по каждой сгруппированной статистике
        for (Statistic groupStatistic : statisticsGroupByDate) {
            int numOfCorrect = 0;
            Date date = groupStatistic.getDate();
//          Вытаскиваю каждую сущность статистики для данного прохождения (по дате) и просчитываю
//          сколько правильных ответов.
            List<Statistic> statisticsByTest = statisticService.getStatisticsByDateAndUserId(date, 21);
            for (Statistic statistic : statisticsByTest) {
                if(statistic.isCorrect()){
                    numOfCorrect++;
                }
            }
//          Filling view and send it to model
            PersonalStatisticForUser psuModel = new PersonalStatisticForUser();
            User user = userService.getUserById(21);
            double percent = ((double) numOfCorrect/statisticsByTest.size())*100;
            psuModel.setFio(user.getFirstName()+" "+user.getLastName());
            psuModel.setCompleted(statisticsByTest.size());
            psuModel.setNameOfTest( groupStatistic.getQuestion().getTest().getName());
            psuModel.setPercent(Math.round(percent));
            psuModel.setQuestion("????");
            psu.add(psuModel);
        }

        model.addAttribute("statistics",psu);

        return "/userStatistic/userStatistic";
    }



}

