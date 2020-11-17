/*
@author Andrei Gorevoi
*/
package com.controller.user;
import com.controller.BaseController;
import com.controller.staticstic.PersonalStatisticService;
import com.dto.QuestionDto;
import com.model.*;
import com.service.answer.AnswerService;
import com.service.question.QuestionDtoService;
import com.service.statistic.StatisticService;
import com.service.test.TestService;
import com.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * User controller отвечает за мапинг views с запросами касающихся части юзера:
 * прохождение тестов, просмотр статистики после теста, общая статистика по вопросам.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    private final TestService testService;
    private final AnswerService answerService;
    private final StatisticService statisticService;
    private final QuestionDtoService questionDtoService;
    private final TopicService topicService;
    private final PersonalStatisticService personalStatisticService;

    @Autowired
    public UserController(TestService testService, AnswerService answerService, StatisticService statisticService, QuestionDtoService questionDtoService, TopicService topicService, PersonalStatisticService personalStatisticService) {
        this.testService = testService;
        this.answerService = answerService;
        this.statisticService = statisticService;
        this.questionDtoService = questionDtoService;
        this.topicService = topicService;
        this.personalStatisticService = personalStatisticService;
    }

    /**
     *
     * @return view для главной станицы пользователя с ролью user
     */
    @GetMapping("/main")
    public String getMainForUser(){
        return "/user/indexUser";
    }

    /**
     *
     * @param model
     * @return view с топиками
     */
    @GetMapping("/topics")
    public String getAll(Model model) {
        model.addAttribute("topics",topicService.getPage(0,7,"ASC","name").getContent());
        return "/user/passingTest/topicsUser";
    }

    /**
     *
     * @param model
     * @return view
     *
     * Данный метод передает на view статистику для каждого пройденого теста для залогированного
     * юзера;
     */
    @GetMapping("/statistic")
    public String statisticByUser(Model model){
        model.addAttribute("statistics",personalStatisticService.getPersonalStatistic());
        return "/user/userStatistic/userStatistic";
    }

    /**
     *
     * @param model
     * @param topicId
     * @return view
     * Данный метод возвращает представление со всеми тестами для конкретного топика по id
     */
    @GetMapping("/tests/{topicId}")
    public String getTests(Model model, @PathVariable int topicId){
        model.addAttribute("tests",testService.getByTopic(topicId,0,7,"ASC","name").getContent());
        return "/user/passingTest/testsList";
    }

    /**
     *
     * @param model
     * @param testId
     * @return view с тестом и топиком для страницы старта конкретного теста
     */
    @GetMapping("/test/{testId}")
    public String getOne(Model model, @PathVariable int testId) {
        Test test = testService.getOne(testId);
        Topic topic = topicService.getOne(test.getTopic().getTopicId());
        model.addAttribute("test", test);
        model.addAttribute("topic", topic);
        return "/user/passingTest/testStart";
    }

    /**
     *
     * @param id
     * @param model
     * @param session
     * @return
     *
     * Данный метод принимает id теста, который выбрал пользователь для прохождения, при первом обращении достает
     * список вопросов и ответов к ним из базы данных и сохраняет все в сессию. Находит в текущем списке вопросов
     * вопрос, который еще не ответил пользователь и передает его на представление.
     */
    @GetMapping("/passing/{id}")
    public String passingTest(@PathVariable int id, Model model, HttpSession session){
        if(session.getAttribute("questions")==null){
            questionDtoService.questionsToSession(id, session);
        }
//        Finding no answered question;
        model.addAttribute("question",questionDtoService.findNoAnsweredQuestion(questionDtoService.getQuestionsFromSession(session)));
        if(model.getAttribute("question") == null){
//        Saving all statistics from session to DB;
            statisticService.addListOfStatistics((List<Statistic>) session.getAttribute("statistics"));
//           Cleaning attributes from session
            session.removeAttribute("questions");
            session.removeAttribute("passingTest");
            session.removeAttribute("answersMap");

            return "redirect:/statistic/test/final";
        }
        return "/user/passingTest/runningTest";
    }


}
