/*
@author Andrei Gorevoi
*/
package com.controller.staticstic;

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

    public List<PersonalStatisticForUser> getPersonalStatistic(int id){
        //        TODO id from security
        List<Statistic> groupedStatistics = statisticService.getStatisticByUserIdGroupByDQuestionId(id);
        List<PersonalStatisticForUser> psu = new ArrayList<>();
//        TODO id from security
        User user = userService.getUserById(id);
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

    } public List<PersonalStatisticForUser> getPersonalStatisticByUsers(int id){
        //        TODO id from security

        List<Statistic> groupedStatistics = statisticService.getStatisticByUserIdGroupByDate(id);
        List<PersonalStatisticForUser> psu = new ArrayList<>();
//        TODO id from security
        User user = userService.getUserById(id);
        for (Statistic statistic : groupedStatistics) {
            int numOfCorrect=0;
            int completed = 0;
//            TODO id from security
            List<Statistic> statisticsByOneTest = statisticService.getStatisticsByDateAndUserId(statistic.getDate(), id);
            for (Statistic statistic1 : statisticsByOneTest) {
                if(statistic1.isCorrect()){
                    numOfCorrect++;
                }
            }
            completed=statisticsByOneTest.size();
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
