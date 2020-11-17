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

    /**
     *
     * @param newAnswer
     * @return Answer
     * Метод принимает новый отве и сохраняет его в базу данных
     */
    @Override
    public Answer addAnswer(Answer newAnswer) {
     return answerRepository.save(newAnswer);
    }

    /**
     *
     * @param id
     * Метод удаляет конкретный отве по id
     */
    @Override
    public void deleteAnswerById(int id) {
        answerRepository.deleteAnswerById(id);
    }

    /**
     *
     * @param updatedAnswer
     * Метод принимает заполненный объект обновленного ответа и сохраняет/перезаписывает его в базу
     */
    @Override
    public void updateAnswer(Answer updatedAnswer) {
        answerRepository.save(updatedAnswer);
    }

    /**
     *
     * @param id
     * @return Answer
     * Метод ищет конкретный ответ по id в базе данных
     */
    @Override
    public Answer getAnswerById(int id) {
        return answerRepository.findAnswerById(id);
    }

    /**
     *
     * @return List<Answer>
     *     Метод возвращает все имеющиеся ответы в базе данных
     */
    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    /**
     *
     * @param id
     * @return List<Answer>
     * Метод возвращает все имеющиеся вопросы для вопроса по его id
     */
    @Override
    public List<Answer> getAllAnswersByQuestionId(int id) {
        return answerRepository.findAllAnswersByQuestionId(id);
    }

    /**
     *
     * @param id
     * @return List<Answer>
     * Метод возвращает все правильные ответы для вопроса по его id
     */
    @Override
    public List<Answer> getTrueAnswersForQuestion(int id) {
        return answerRepository.findTrueAnswersForQuestion(id);
    }
}
