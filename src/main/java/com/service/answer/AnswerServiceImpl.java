/*
@author Andrei Gorevoi
*/
package com.service.answer;

import com.model.Answer;
import com.repository.answer.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        answerRepository.addAnswer(newAnswer);
    }

    @Override
    public void deleteAnswerById(Long id) {
        answerRepository.deleteAnswerById(id);
    }

    @Override
    public void updateAnswer(Answer updatedAnswer) {
        answerRepository.updateAnswer(updatedAnswer);
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findAnswerById(id);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAllAnswers();
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(Long id) {
        return answerRepository.findAllAnswersByQuestionId(id);
    }
}
