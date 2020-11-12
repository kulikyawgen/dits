package com.repository.statistic;

import com.model.Question;
import com.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatisticRepo extends JpaRepository<Statistic, Integer> {
    @Query("select s from Statistic s where s.date = :date")
    List<Statistic> getAllByDate(Date date);

    @Query("from Statistic s where s.question.questionId= :id")
    List<Statistic> getAllStatisticByQuestionId(@Param("id") int id);

    @Query("from Statistic s where s.question.test.testId= :testId")
    List<Statistic> findStatisticByTestId(@Param("testId") int testId);

    @Query("from Statistic s where s.user.userId = :userId ")
    List<Statistic> findStatisticByTestUser(@Param("userId") int userId);
}
