/*
@author Andrei Gorevoi
*/
package com.controller.staticstic;

import com.controller.BaseController;
import com.dto.QuestionDto;
import com.model.Answer;
import com.model.Statistic;
import com.service.answer.AnswerService;
import com.service.link.LinkService;
import com.service.literature.LiteratureService;
import com.service.question.QuestionService;
import com.service.statistic.StatisticService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class StatisticRestController extends BaseController {

    private final StatisticService statisticService;
    private final QuestionService questionService;
    private final UserService userService;
    private final AnswerService answerService;
    private final LiteratureService literatureService;
    private final LinkService linkService;

    @Autowired
    public StatisticRestController(StatisticService statisticService, QuestionService questionService, UserService userService, AnswerService answerService, LiteratureService literatureService, LinkService linkService) {
        this.statisticService = statisticService;
        this.questionService = questionService;
        this.userService = userService;
        this.answerService = answerService;
        this.literatureService = literatureService;
        this.linkService = linkService;
    }

    /**
     *
     * @param str
     * @param session
     * @return
     * Данный метод создает статистику для отвеченного вопроса и помещает ее в сессию. Номер вопроса приходит первым
     * элементом в 'str'. Так же данный метод меняет флаг на отвеченный для текущего вопроса.
     */
    @PostMapping("/statistic")
    public Statistic addStatisticToSession(@RequestBody List<String> str,HttpSession session){
        Integer questionId = Integer.valueOf(str.get(0));
        List<Answer> trueAnswersForQuestion = answerService.getTrueAnswersForQuestion(questionId);
        List<String> truAnswersList = trueAnswersForQuestion.stream().map(it -> it.getDescription()).collect(Collectors.toList());
        //        Remove question id in answers list from view
        str.remove(0);
        //        Save statistic for user
        Statistic statistic = new Statistic();
        statistic.setDate((Date) session.getAttribute("startTime"));
        statistic.setQuestion(questionService.getOne(questionId));
        statistic.setUser(userService.getUserById(getCurrentUser().getId()));

            //        Checking for correct TODO check situation with many of correct answers
        if(truAnswersList.equals(str)){
                statistic.setCorrect(true);
            }else {
                statistic.setCorrect(false);
            }
        List<Statistic> statisticsList = (List<Statistic>) session.getAttribute("statistics");
        statisticsList.add(statistic);

        List<QuestionDto> questionDtoList = (List<QuestionDto>) session.getAttribute("questions");
            for (QuestionDto questionDto : questionDtoList) {
                if (questionDto.getQuestionId()==questionId){
                    questionDto.setAnswered(true);
                    break;
                }
            }
            return statistic;
    }

}
