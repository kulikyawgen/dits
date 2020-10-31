package com.repository.statistic;

import com.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatisticRepo extends JpaRepository<Statistic, Integer> {
    @Query("select s from Statistic s where s.date = :date")
    List<Statistic> getAllByDate(Date date);
}
