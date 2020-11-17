package com.repository.statistic;

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

    @Query("from Statistic s where s.user.userId=?1 group by s.date")
    List<Statistic> getStatisticByUserIdGroupByDate(int userId);

    @Query("from Statistic s where s.user.userId=?1 group by s.question.questionId")
    List<Statistic> getStatisticByUserIdGroupByQuestionId(int userId);

    @Query("from Statistic s where s.date=?1 and s.user.userId=?2")
    List<Statistic> getStatisticsByDateAndUserId(Date date, int userId);

    @Query("from Statistic s where s.question.questionId=?1 and s.user.userId=?2")
    List<Statistic> getStatisticsByQuestionIdAndUserId(int questionId, int userId);

    @Query("select count(ALL s) from Statistic s where " +
            "s.question.questionId=:questionId and s.user.userId =:userId ")
    int getCountUserCompletedTest(@Param("userId") int userId, @Param("questionId") int questionId);

    @Query("select distinct q.test.testId from Statistic s left join Question q on s.question.questionId = q.questionId where s.user.userId =:id")
    List<Integer> getDistinctTestByUser(@Param("id") int id);


    @Query("select s from Statistic s left join Question q on s.question.questionId = q.questionId  where s.user.userId =:userId and  q.test.testId =:testId group by s.date")
    List<Statistic> getStatisticsGroupByDateWhereTestIdAndUserId(@Param("testId") int testId, @Param("userId") int userId);
}
