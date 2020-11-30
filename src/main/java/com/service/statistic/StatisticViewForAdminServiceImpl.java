package com.service.statistic;

import com.model.StatisticViewForAdmin;
import com.model.*;
import com.service.question.QuestionService;
import com.service.test.TestService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author EKulik
 */
@Service
public class StatisticViewForAdminServiceImpl implements StatisticViewForAdminService {
    @Autowired
    private TestService testService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    /**
     * Метотод получения статистик по вопросам, т.е сколько раз был пройден определенный вопрос и
     * процент правильных ответов.
     *
     * @return лист DTOстатистик
     */
    @Override
    public List<StatisticViewForAdmin> getQuestionStatisticList() {
        List<StatisticViewForAdmin> questionList = new ArrayList<>();
        StatisticViewForAdmin viewStatistic;
        List<Question> allQuestion = questionService.getAllQuestion();
        for (Question question : allQuestion) {
            viewStatistic = getQuestionInfo(question);
            if (viewStatistic != null) {
                questionList.add(viewStatistic);
            }
        }
        return questionList;
    }

    /**
     * Метод получения статистики по вопросу
     *
     * @param question
     * @return DTO статистики
     * @see StatisticViewForAdminServiceImpl getQuestionStatisticList()
     */
    @Override
    public StatisticViewForAdmin getQuestionInfo(Question question) {
        StatisticViewForAdmin statisticViewForAdmin = null;
        List<Statistic> allStatisticByQuestionId = statisticService.getAllStatisticByQuestionId(question.getQuestionId());
        if (!allStatisticByQuestionId.isEmpty()) {
            countPercentOfTrue(allStatisticByQuestionId);
            statisticViewForAdmin = new StatisticViewForAdmin();
            statisticViewForAdmin.setName(question.getDescription());
            statisticViewForAdmin.setCountCompleted(allStatisticByQuestionId.size());
            statisticViewForAdmin.setPercent(countPercentOfTrue(allStatisticByQuestionId));
        }
        return statisticViewForAdmin;
    }

    /**
     * Метод получения статистик по результатам прохождения тестов
     *
     * @return лист дто статистик
     */
    @Override
    public List<StatisticViewForAdmin> getTestStatisticList() {
        List<StatisticViewForAdmin> testInfoList = new ArrayList<>();
        StatisticViewForAdmin statisticViewForAdmin;
        List<Test> allTests = testService.getAllTests();
//        TODO можно использовать стрим вместо цикла
        for (Test test : allTests) {
            statisticViewForAdmin = getTestInfo(test);
            if (statisticViewForAdmin != null) {
                testInfoList.add(statisticViewForAdmin);
            }
        }
        testInfoList.sort(Comparator.comparing(StatisticViewForAdmin::getName));
        return testInfoList;
    }

    /**
     * Метод получения статистик по результатам прохождения определенного теста
     *
     * @param test
     * @return лист дто статистик
     * @see StatisticViewForAdminServiceImpl getTestStatisticList()
     */
    @Override
    public StatisticViewForAdmin getTestInfo(Test test) {
        StatisticViewForAdmin statisticViewForAdmin;
        List<Statistic> allStatistic = statisticService.getFilteredStatisticByTestId(test.getTestId());
        if (!allStatistic.isEmpty()) {
            int numberOfQuestionInTest = test.getQuestions().size();
            int size = allStatistic.size();
            statisticViewForAdmin = new StatisticViewForAdmin();
            statisticViewForAdmin.setName(test.getName());
            statisticViewForAdmin.setCountCompleted(size / numberOfQuestionInTest);
            statisticViewForAdmin.setPercent(countPercentOfTrue(allStatistic));
        } else statisticViewForAdmin = null;
        return statisticViewForAdmin;
    }

    /**
     * Метод получения процента правильных ответов в списке статистики
     *
     * @param statisticList
     * @return % правильных отвеветов в инт переменной
     */
    private int countPercentOfTrue(List<Statistic> statisticList) {
        int numOfList = statisticList.size();
        int numOfCorrect = 0;
        for (Statistic statistic : statisticList) {
            if (statistic.isCorrect()) {
                numOfCorrect++;
            }
        }
        return (int) Math.round(((double) numOfCorrect) / numOfList * 100);
    }

    /**
     * Метод получения статистики по пользователям т.е сколько каждый пользователь прокходил определенный тест и % правильности
     *
     * @return лист дто статистик
     */
    @Override
    public List<StatisticViewForAdmin> getUserTestStatisticList() {
        StatisticViewForAdmin statisticViewForAdmin;
        List<StatisticViewForAdmin> userTestInfoList = new ArrayList<>();
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
                        avgPercent += countPercentOfTrue(statisticsByDateAndUserId);
                        ;
                    }
                    avgPercent = avgPercent / statisticsGroupByDateWhereTestIdAndUserId.size();
                    statisticViewForAdmin = new StatisticViewForAdmin();
                    statisticViewForAdmin.setLogin(user.getLogin());
                    statisticViewForAdmin.setName(testService.getOne(integer).getName());
                    statisticViewForAdmin.setCountCompleted(numOfCompleted);
                    statisticViewForAdmin.setPercent((int) avgPercent);
                    userTestInfoList.add(statisticViewForAdmin);
                }
            }
        }
        return userTestInfoList;
    }
}