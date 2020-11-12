/*
@author Andrei Gorevoi
*/
package com.repository.answer;

import com.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    @Query("delete from Answer where answerId=?1")
    void deleteAnswerById(int id);

    @Query("from Answer where answerId=?1")
    Answer findAnswerById(int id);

    @Query("from Answer where questionid.questionId=?1")
    List<Answer> findAllAnswersByQuestionId(int id);

    @Query("from Answer where questionid.questionId=?1 and correct=true")
    List<Answer> findTrueAnswersForQuestion(int id);
}
