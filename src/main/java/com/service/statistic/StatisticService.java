/*
@author Andrei Gorevoi
*/
package com.service.statistic;

import com.model.Statistic;

import java.util.List;

public interface StatisticService {
    Statistic addStatistic(Statistic newStatistic);
    List<Statistic> getAllStatistics();
    List<Statistic> getAllStatisticsByUserId(Long id);
    Statistic getStatisticByTopicByQuestionId(Long id);
    boolean deleteStatisticById(Long id);
    void updateStatistic(Statistic updatedStatistic);
}
