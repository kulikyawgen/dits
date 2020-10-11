/*
@author Andrei Gorevoi
*/
package com.service.answer;

import com.model.Answer;

import java.util.List;

public interface AnswerService {
    Answer addAnswer(Answer newAnswer);
    void deleteAnswerById(int id);
    void updateAnswer(Answer updatedAnswer);
    Answer getAnswerById(int id);
    List<Answer> getAllAnswers();
    List<Answer> getAllAnswersByQuestionId(int id);
    List<Answer> getTrueAnswersForQuestion(int id);
}
