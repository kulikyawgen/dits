/*
@author Andrei Gorevoi
*/
package com.service.statistic;

import com.model.Statistic;
import com.repository.statistic.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public Statistic addStatistic(Statistic newStatistic) {
        return statisticRepository.addStatistic(newStatistic);
    }

    @Override
    public List<Statistic> getAllStatistics() {
        return statisticRepository.findAllStatistics();
    }

    @Override
    public List<Statistic> getAllStatisticsByUserId(Long id) {
        return statisticRepository.findAllStatisticsByUserId(id);
    }

    @Override
    public Statistic getStatisticByTopicByQuestionId(Long id) {
        return statisticRepository.findStatisticByTopicByQuestionId(id);
    }

    @Override
    public boolean deleteStatisticById(Long id) {
        statisticRepository.deleteStatisticById(id);
        return true;
    }

    @Override
    public void updateStatistic(Statistic updatedStatistic) {
        statisticRepository.updateStatistic(updatedStatistic);
    }
}
