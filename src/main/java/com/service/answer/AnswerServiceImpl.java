/*
@author Andrei Gorevoi
*/
package com.service.answer;

import com.model.Answer;
import com.model.Question;
import com.repository.AnswerRepository;
import com.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
    }

    @Override
    public void addAnswer(Answer newAnswer) {
        answerRepository.save(newAnswer);
    }

    @Override
    public void deleteAnswerById(Long id) {
        answerRepository.deleteById(id);
    }

    @Override
    public void updateAnswer(Answer updatedAnswer) {
        answerRepository.save(updatedAnswer);
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.getOne(id);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(int id) {
        Question question = questionService.getOne(id);
        return answerRepository.findByQuestionid(question);
    }
}