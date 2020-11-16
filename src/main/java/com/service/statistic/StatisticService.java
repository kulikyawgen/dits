package com.service.statistic;

import com.model.Link;
import com.model.Statistic;

import java.util.Date;
import java.util.List;

public interface StatisticService {
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
    List<Statistic> getStatisticsByQuestionIdAndUserId(int questionId,int userId);
    List<Statistic> getStatisticForTests(int id);
}
