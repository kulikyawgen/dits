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
        return staticRepo.findStatisticByTestUser(id);
    }

    @Override
    public List<Statistic> getAllStatisticByQuestionId(int id) {
        return staticRepo.getAllStatisticByQuestionId(id);
    }

    public List<Statistic> getFilteredStatisticByTestUser(int id) { return staticRepo.findStatisticByTestUser(id);
    }

    public List<Statistic> findAll(){ return staticRepo.findAll();}

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
        return staticRepo.getStatisticsByQuestionIdAndUserId(questionId,userId);
    }

    @Override
    public List<Statistic> getStatisticForTests(int id) {
        return staticRepo.getStatisticForTests(id);
    }

}