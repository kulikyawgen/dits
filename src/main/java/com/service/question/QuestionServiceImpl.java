/*
@author Andrei Gorevoi
*/
package com.service.question;

import com.model.Question;
import com.repository.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void addQuestion(Question newQuestion) {
        questionRepository.addQuestion(newQuestion);
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.deleteQuestionById(id);
    }

    @Override
    public void updateQuestion(Question updatedQuestion) {
        questionRepository.updateQuestion(updatedQuestion);
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findQuestionById(id);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAllQuestion();
    }

    @Override
    public List<Question> getAllTestsByTestId(Long id) {
        return questionRepository.findAllTestsByTestId(id);
    }
}
