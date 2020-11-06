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
    Statistic getStatisticByQuestionIdAndDate(int questionId,Date date);
}
