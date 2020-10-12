package com.service.answer;

import com.dto.AnswerDto;
import com.mapper.AnswerMapper;
import com.model.Answer;
import com.model.Question;
import com.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnswerDtoServiceWrapper {

    @Autowired
    private AnswerService answerService;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private QuestionService questionService;

    public void addAnswer(AnswerDto newAnswer) {
        Question question = questionService.getOne(newAnswer.getQuestionId());
        Answer answer = answerMapper.toAnswer(newAnswer);
        question.addAnswer(answer);
        answerService.addAnswer(answer);
    }

    public void deleteAnswerById(Long id) {
        answerService.deleteAnswerById(id);
    }

    public void updateAnswer(AnswerDto updatedAnswer) {
        Answer fromDB = answerService.getAnswerById((long) updatedAnswer.getAnswerId());
        answerMapper.update(updatedAnswer, fromDB);
        answerService.updateAnswer(fromDB);
    }

    public AnswerDto getAnswerById(Long id) {
        return answerMapper.toAnswerDto(answerService.getAnswerById(id));
    }

    public List<AnswerDto> getAllAnswers() {
        return answerService.getAllAnswers().stream()
                .map(answerMapper::toAnswerDto)
                .collect(Collectors.toList());
    }

    public List<AnswerDto> getAllAnswersByQuestionId(int id) {
        return answerService.getAllAnswersByQuestionId(id)
                .stream().map(answerMapper::toAnswerDto)
                .collect(Collectors.toList());
    }
}