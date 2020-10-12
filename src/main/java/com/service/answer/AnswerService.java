/*
@author Andrei Gorevoi
*/
package com.service.answer;

import com.model.Answer;

import java.util.List;

public interface AnswerService {
    void addAnswer(Answer newAnswer);

    void deleteAnswerById(Long id);

    void updateAnswer(Answer updatedAnswer);

    Answer getAnswerById(Long id);

    List<Answer> getAllAnswers();

    List<Answer> getAllAnswersByQuestionId(int id);
}
