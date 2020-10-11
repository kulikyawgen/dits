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
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer addAnswer(Answer newAnswer) {
     return answerRepository.save(newAnswer);
    }

    @Override
    public void deleteAnswerById(int id) {
        answerRepository.deleteAnswerById(id);
    }

    @Override
    public void updateAnswer(Answer updatedAnswer) {
        answerRepository.save(updatedAnswer);
    }

    @Override
    public Answer getAnswerById(int id) {
        return answerRepository.findAnswerById(id);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(int id) {
        return answerRepository.findAllAnswersByQuestionId(id);
    }

    @Override
    public List<Answer> getTrueAnswersForQuestion(int id) {
        return answerRepository.findTrueAnswersForQuestion(id);
    }
}
