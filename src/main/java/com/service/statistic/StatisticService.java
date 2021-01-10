package com.service.statistic;

import com.model.Statistic;

import java.util.Date;
import java.util.List;

public interface StatisticService {
//    TODO documentation
    List<Statistic> getAllByDate(Date date);
    Statistic addStatistic(Statistic statistic);
    void delete(Statistic statistic);
    void updateStatistic(Statistic statistic);
    Statistic getStatisticById(int id);
    List<Statistic> getAllStatistic();
    List<Statistic> getFilteredStatisticByTestId(int id);
    List<Statistic> getAllStatisticByQuestionId(int id);
    List<Statistic> getStatisticByUserIdGroupByDate(int userId);
    List<Statistic> getStatisticsByDateAndUserId(Date date,int userId);
    List<Statistic> getStatisticByUserIdGroupByDQuestionId(int userId);
    List<Statistic> getStatisticsByQuestionIdAndUserId(int questionId, int userId);
    int getCountUserCompletedTest(int userId, int questionId);
    List<Statistic> getAll();
    List<Integer> getDistinctTestByUser(int id);
    List<Statistic> getStatisticsGroupByDateWhereTestIdAndUserId(int testId, int userId);
    List<Statistic> addListOfStatistics(List<Statistic> statisticList);
}
