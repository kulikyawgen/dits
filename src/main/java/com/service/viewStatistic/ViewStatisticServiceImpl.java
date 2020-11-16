package com.service.viewStatistic;

import com.model.*;
import com.service.question.QuestionService;
import com.service.statistic.StatisticService;
import com.service.test.TestService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ViewStatisticServiceImpl implements ViewStatisticService {
    @Autowired
    private TestService testService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Override
    public List<ViewStatistic> getQuestionStatisticList() {
        List<ViewStatistic> questionList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Question> allQuestion = questionService.getAllQuestion();
        for (Question question : allQuestion) {
            viewStatistic = getQuestionInfo(question);
            if (viewStatistic != null) {
                questionList.add(viewStatistic);
            }
        }
        return questionList;
    }

    @Override
    public ViewStatistic getQuestionInfo(Question question) {
        ViewStatistic viewStatistic;
        viewStatistic = null;
        List<Statistic> allStatisticByQuestionId = statisticService.getAllStatisticByQuestionId(question.getQuestionId());
        if (!allStatisticByQuestionId.isEmpty()) {
            int size = allStatisticByQuestionId.size();
            int countOfCorrectAnswers = 0;
            for (Statistic statistic : allStatisticByQuestionId) {
                if (statistic.isCorrect()) {
                    countOfCorrectAnswers++;
                }
                viewStatistic = new ViewStatistic();
                viewStatistic.setName(question.getDescription());
                viewStatistic.setCountCompleted(size);
                viewStatistic.setPercent((int) Math.round(((double) countOfCorrectAnswers) / size * 100));
            }
        } else viewStatistic = null;
        return viewStatistic;
    }

    @Override
    public List<ViewStatistic> getTestStatisticList() {
        List<ViewStatistic> testInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Test> allTests = testService.getAllTests();
        for (Test test : allTests) {
            viewStatistic = getTestInfo(test);
            if (viewStatistic != null) {
                testInfoList.add(viewStatistic);
            }
        }
        testInfoList.sort(Comparator.comparing(ViewStatistic::getName));
        return testInfoList;
    }

    @Override
    public ViewStatistic getTestInfo(Test test) {
        ViewStatistic viewStatistic;
        List<Statistic> allStatistic = statisticService.getFilteredStatisticByTestId(test.getTestId());
        if (!allStatistic.isEmpty()) {
            int numberOfQuestionInTest = test.getQuestions().size();
            int size = allStatistic.size();
            viewStatistic = new ViewStatistic();
            viewStatistic.setName(test.getName());
            viewStatistic.setCountCompleted(size / numberOfQuestionInTest);
            viewStatistic.setPercent((int) Math.round(((double) numberOfQuestionInTest) / size * 100));// viewStatistic.setPercent();
        } else viewStatistic = null;
        return viewStatistic;
    }


    private int countPercentOfTrue(List<Statistic> list) {
        int numOfList = list.size();
        int numOfCorrect = 0;
        for (Statistic statistic : list) {
            if (statistic.isCorrect()) {
                numOfCorrect++;
            }
        }
        return (int) Math.round(((double) numOfCorrect) / numOfList * 100);
    }

    @Override
    public List<ViewStatistic> getUserTestStatisticList() {
        ViewStatistic viewStatistic;
        List<ViewStatistic> userTestInfoList = new ArrayList<>();
        List<User> allUser = userService.getAllUser();
        for (User user : allUser) {
            List<Integer> distinctTestByUser = statisticService.getDistinctTestByUser(user.getUserId());
            if (!distinctTestByUser.isEmpty()) {
                for (Integer integer : distinctTestByUser) {
                    List<Statistic> statisticsGroupByDateWhereTestIdAndUserId = statisticService.getStatisticsGroupByDateWhereTestIdAndUserId(integer, user.getUserId());
                    double avgPercent = 0;
                    int numOfCompleted = statisticsGroupByDateWhereTestIdAndUserId.size();
                    for (Statistic statistic : statisticsGroupByDateWhereTestIdAndUserId) {
                        List<Statistic> statisticsByDateAndUserId = statisticService.getStatisticsByDateAndUserId(statistic.getDate(), user.getUserId());
                        countPercentOfTrue(statisticsByDateAndUserId);
                        avgPercent += countPercentOfTrue(statisticsByDateAndUserId);;
                    }
                    avgPercent = avgPercent / statisticsGroupByDateWhereTestIdAndUserId.size();
                    viewStatistic = new ViewStatistic();
                    viewStatistic.setLogin(user.getLogin());
                    viewStatistic.setName(testService.getOne(integer).getName());
                    viewStatistic.setCountCompleted(numOfCompleted);
                    viewStatistic.setPercent((int) avgPercent);
                    userTestInfoList.add(viewStatistic);
                }
            }
        }
        return userTestInfoList;
    }
}