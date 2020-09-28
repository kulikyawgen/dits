/*
@author Andrei Gorevoi
*/
package com.repository.question;

import com.model.Question;

import java.util.List;

public interface QuestionRepository {
    void addQuestion(Question newQuestion);
    void deleteQuestionById(Long id);
    void updateQuestion(Question updatedQuestion);
    Question findQuestionById(Long id);
    List<Question> findAllQuestion();
    List<Question> findAllTestsByTestId(Long id);
}
