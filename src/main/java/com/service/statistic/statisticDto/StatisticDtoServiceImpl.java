package com.service.statistic.statisticDto;

import com.dto.StatisticDto;
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

/**
 * @author EKulik
 */
@Service
public class StatisticDtoServiceImpl implements StatisticDtoService {
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
     * @return лист DTOстатистик
     */
    @Override
    public List<StatisticDto> getQuestionStatisticList() {
        List<StatisticDto> questionList = new ArrayList<>();
        StatisticDto viewStatistic;
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
     *Метод получения статистики по вопросу
     * @see StatisticDtoServiceImpl getQuestionStatisticList()
     * @param question
     * @return DTO статистики
     */
    @Override
    public StatisticDto getQuestionInfo(Question question) {
        StatisticDto statisticDto = null;
        List<Statistic> allStatisticByQuestionId = statisticService.getAllStatisticByQuestionId(question.getQuestionId());
        if (!allStatisticByQuestionId.isEmpty()) {
            countPercentOfTrue(allStatisticByQuestionId);
            statisticDto = new StatisticDto();
            statisticDto.setName(question.getDescription());
            statisticDto.setCountCompleted(allStatisticByQuestionId.size());
            statisticDto.setPercent(countPercentOfTrue(allStatisticByQuestionId));
        }
        return statisticDto;
    }
    /**
     * Метод получения статистик по результатам прохождения тестов
     * @return лист дто статистик*/
    @Override
    public List<StatisticDto> getTestStatisticList() {
        List<StatisticDto> testInfoList = new ArrayList<>();
        StatisticDto statisticDto;
        List<Test> allTests = testService.getAllTests();
//        TODO можно использовать стрим вместо цикла
        for (Test test : allTests) {
            statisticDto = getTestInfo(test);
            if (statisticDto != null) {
                testInfoList.add(statisticDto);
            }
        }
        testInfoList.sort(Comparator.comparing(StatisticDto::getName));
        return testInfoList;
    }
    /**
     * Метод получения статистик по результатам прохождения определенного теста
     * @see StatisticDtoServiceImpl getTestStatisticList()
     * @param test
     * @return лист дто статистик*/
    @Override
    public StatisticDto getTestInfo(Test test) {
        StatisticDto statisticDto;
        List<Statistic> allStatistic = statisticService.getFilteredStatisticByTestId(test.getTestId());
        if (!allStatistic.isEmpty()) {
            int numberOfQuestionInTest = test.getQuestions().size();
            int size = allStatistic.size();
            statisticDto = new StatisticDto();
            statisticDto.setName(test.getName());
            statisticDto.setCountCompleted(size / numberOfQuestionInTest);
            statisticDto.setPercent(countPercentOfTrue(allStatistic));
        } else statisticDto = null;
        return statisticDto;
    }
/**
 * Метод получения процента правильных ответов в списке статистики
 * @param statisticList
 * @return % правильных отвеветов в инт переменной
 * */
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
 * @return лист дто статистик */
    @Override
    public List<StatisticDto> getUserTestStatisticList() {
        StatisticDto statisticDto;
        List<StatisticDto> userTestInfoList = new ArrayList<>();
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
                    statisticDto = new StatisticDto();
                    statisticDto.setLogin(user.getLogin());
                    statisticDto.setName(testService.getOne(integer).getName());
                    statisticDto.setCountCompleted(numOfCompleted);
                    statisticDto.setPercent((int) avgPercent);
                    userTestInfoList.add(statisticDto);
                }
            }
        }
        return userTestInfoList;
    }
}