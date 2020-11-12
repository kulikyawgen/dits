/*
@author Andrei Gorevoi
*/
package com.controller.staticstic.user;

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
public class PersonalStatisticService {

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
        //        TODO id from security
        List<Statistic> groupedStatistics = statisticService.getStatisticByUserIdGroupByDQuestionId(21);
        List<PersonalStatisticForUser> psu = new ArrayList<>();
//        TODO id from security
        User user = userService.getUserById(21);
        for (Statistic statistic : groupedStatistics) {
            int numOfCorrect=0;
            int completed = 0;
//            TODO id from security
            List<Statistic> statisticsByOneQuestion = statisticService.getStatisticsByQuestionIdAndUserId(statistic.getQuestion().getQuestionId(), 21);
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
