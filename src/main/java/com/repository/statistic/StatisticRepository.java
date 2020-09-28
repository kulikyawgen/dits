/*
@author Andrei Gorevoi
*/
package com.repository.statistic;

import com.model.Statistic;

import java.util.List;

public interface StatisticRepository {

    Statistic addStatistic(Statistic newStatistic);
    List<Statistic> findAllStatistics();
    List<Statistic> findAllStatisticsByUserId(Long id);
    Statistic findStatisticByTopicByQuestionId(Long id);
    boolean deleteStatisticById(Long id);
    void updateStatistic(Statistic updatedStatistic);

}
