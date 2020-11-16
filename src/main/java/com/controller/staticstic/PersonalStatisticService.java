/*
@author Andrei Gorevoi
*/
package com.controller.staticstic;

import com.controller.BaseController;
import com.model.PersonalStatisticForUser;
import com.model.Statistic;
import com.model.User;
import com.service.statistic.StatisticService;
import com.service.test.TestService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalStatisticService extends BaseController {

    private final StatisticService statisticService;
    private final TestService testService;
    private final UserService userService;


    @Autowired
    public PersonalStatisticService(StatisticService statisticService, TestService testService, UserService userService) {
        this.statisticService = statisticService;
        this.testService = testService;
        this.userService = userService;
    }

    public List<PersonalStatisticForUser> getPersonalStatistic(){
        List<Statistic> groupedStatistics = statisticService.getStatisticByUserIdGroupByDQuestionId(getCurrentUser().getId());
        List<PersonalStatisticForUser> psu = new ArrayList<>();
        User user = userService.getUserById(getCurrentUser().getId());
        for (Statistic statistic : groupedStatistics) {
            int numOfCorrect=0;
            int completed = 0;
            List<Statistic> statisticsByOneQuestion = statisticService.getStatisticsByQuestionIdAndUserId(statistic.getQuestion().getQuestionId(), getCurrentUser().getId());
            for (Statistic statistic1 : statisticsByOneQuestion) {
                if(statistic1.isCorrect()){
                    numOfCorrect++;
                }
            }
            completed=statisticsByOneQuestion.size();
            double percent = Math.round(((double)numOfCorrect/completed)*100);


            PersonalStatisticForUser psuModel = new PersonalStatisticForUser();
            psuModel.setFio(user.getFirstName()+" " + user.getLastName());
            psuModel.setQuestion(statistic.getQuestion().getDescription());
            psuModel.setNameOfTest(testService.getOne(statistic.getQuestion().getTest().getTestId()).getName());
            psuModel.setCompleted(completed);
            psuModel.setPercent(percent);
            psu.add(psuModel);
        }
        return psu;
    }
}
