/*
@author Andrei Gorevoi
*/
package com.repository;

import com.model.Answer;
import com.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionid(Question question);
}