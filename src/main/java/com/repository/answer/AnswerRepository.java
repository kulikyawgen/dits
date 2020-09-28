/*
@author Andrei Gorevoi
*/
package com.repository.answer;

import com.model.Answer;

import java.util.List;

public interface AnswerRepository {
    void addAnswer(Answer newAnswer);
    void deleteAnswerById(Long id);
    void updateAnswer(Answer updatedAnswer);
    Answer findAnswerById(Long id);
    List<Answer> findAllAnswers();
    List<Answer> findAllAnswersByQuestionId(Long id);
}
