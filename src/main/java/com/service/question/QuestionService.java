/*
@author Andrei Gorevoi
*/
package com.service.question;

import com.model.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(Question newQuestion);
    void deleteQuestionById(Long id);
    void updateQuestion(Question updatedQuestion);
    Question getQuestionById(Long id);
    List<Question> getAllQuestion();
    List<Question> getAllTestsByTestId(Long id);
}
