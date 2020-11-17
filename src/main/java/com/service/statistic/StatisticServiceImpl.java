package com.service.statistic;

import com.model.Statistic;
import com.repository.statistic.StatisticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticRepo staticRepo;

    @Override
    public List<Statistic> getAllByDate(Date date) {
        return staticRepo.getAllByDate(date);
    }

    @Override
    public Statistic addStatistic(Statistic statistic) {
        return staticRepo.save(statistic);
    }

    @Override
    public void delete(Statistic statistic) {
        staticRepo.delete(statistic);
    }

    @Override
    public void updateStatistic(Statistic statistic) {
        staticRepo.saveAndFlush(statistic);
    }

    @Override
    public Statistic getStatisticById(int id) {
        return staticRepo.getOne(id);
    }

    @Override
    public List<Statistic> getAllStatistic() {
        return staticRepo.findAll();
    }

    @Override
    public List<Statistic> getFilteredStatisticByTestId(int id) {
        return staticRepo.findStatisticByTestId(id);
    }

    @Override
    public List<Statistic> getAllStatisticByQuestionId(int id) {
        return staticRepo.getAllStatisticByQuestionId(id);
    }

    @Override
    public List<Statistic> getAll() {
        return staticRepo.findAll();
    }

    @Override
    public List<Statistic> getStatisticsGroupByDateWhereTestIdAndUserId(int testId, int userId) {
        return staticRepo.getStatisticsGroupByDateWhereTestIdAndUserId(testId,userId);
    }

    @Override
    public List<Integer> getDistinctTestByUser(int id) {
        return staticRepo.getDistinctTestByUser(id);
    }

//    @Override
//    public List<Statistic> getStatisticsByQuestionId(int questionId) {
//       return staticRepo.getStatisticsByQuestionId(questionId);
//    }

    @Override
    public int getCountUserCompletedTest(int userId, int questionId) {
        return staticRepo.getCountUserCompletedTest(userId, questionId);
    }

    public List<Statistic> findAll() {
        return staticRepo.findAll();
    }

    @Override
    public List<Statistic> getStatisticByUserIdGroupByDate(int userId) {
        return staticRepo.getStatisticByUserIdGroupByDate(userId);
    }

    @Override
    public List<Statistic> getStatisticsByDateAndUserId(Date date, int userId) {
        return staticRepo.getStatisticsByDateAndUserId(date, userId);
    }

    @Override
    public List<Statistic> getStatisticByUserIdGroupByDQuestionId(int userId) {
        return staticRepo.getStatisticByUserIdGroupByQuestionId(userId);
    }

    @Override
    public List<Statistic> getStatisticsByQuestionIdAndUserId(int questionId, int userId) {
        return staticRepo.getStatisticsByQuestionIdAndUserId(questionId, userId);
    }

    @Override
    public List<Statistic> addListOfStatistics(List<Statistic> statisticList) {
        for (Statistic statistic : statisticList) {
            this.addStatistic(statistic);
        }
        return statisticList;
    }


}