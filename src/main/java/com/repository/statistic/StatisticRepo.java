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

   @Query("from Statistic s where s.user.userId=?1 group by s.date")
    List<Statistic> getStatisticByUserIdGroupByDate(int userId);

    @Query("from Statistic s where s.user.userId=?1 group by s.question.questionId")
    List<Statistic> getStatisticByUserIdGroupByQuestionId(int userId);

   @Query("from Statistic s where s.date=?1 and s.user.userId=?2")
   List<Statistic> getStatisticsByDateAndUserId(Date date,int userId);
   @Query("from Statistic s where s.question.questionId=?1 and s.user.userId=?2")
   List<Statistic> getStatisticsByQuestionIdAndUserId(int questionId,int userId);
}
