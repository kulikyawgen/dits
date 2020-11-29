/*
@author Andrei Gorevoi
*/
package com.service.statistic;

import com.model.PersonalStatisticForUser;
import com.model.Statistic;
import com.model.User;
import com.service.test.TestService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalStatisticServiceImpl implements PersonalStatisticService {

    private final StatisticService statisticService;
    private final TestService testService;
    private final UserService userService;


    @Autowired
    public PersonalStatisticServiceImpl(StatisticService statisticService, TestService testService, UserService userService) {
        this.statisticService = statisticService;
        this.testService = testService;
        this.userService = userService;
    }

    public List<PersonalStatisticForUser> getPersonalStatistic(int userId){
        List<Statistic> groupedStatistics = statisticService.getStatisticByUserIdGroupByDQuestionId(userId);
        List<PersonalStatisticForUser> psu = new ArrayList<>();
        User user = userService.getUserById(userId);
        for (Statistic statistic : groupedStatistics) {
            int numOfCorrect=0;
            int completed = 0;
            List<Statistic> statisticsByOneQuestion = statisticService.getStatisticsByQuestionIdAndUserId(statistic.getQuestion().getQuestionId(), userId);
            numOfCorrect= (int) statisticsByOneQuestion.stream().filter(Statistic::isCorrect).count();
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
