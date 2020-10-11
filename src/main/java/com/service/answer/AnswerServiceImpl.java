/*
@author Andrei Gorevoi
*/
package com.service.answer;

import com.model.Answer;
import com.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
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

//    @Override
//    public List<Answer> getAllAnswersByQuestionId(Long id) {
//        return answerRepository.findAllAnswersByQuestionId(id);
//    }
}