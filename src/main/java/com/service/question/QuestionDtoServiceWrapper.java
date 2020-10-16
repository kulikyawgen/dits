package com.service.question;

import com.dto.QuestionDto;
import com.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionDtoServiceWrapper {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionMapper questionMapper;

    public QuestionDto getOne(int id) {
        return questionMapper.toQuestionDto(questionService.getOne(id));
    }

    public Page<QuestionDto> getPage(int page, int size, String order, String... params) {
        return questionService.getPage(page, size, order, params).map(questionMapper::toQuestionDto);
    }

    public Page<QuestionDto> getByTest(int testId, int page, int size, String order, String... params) {
        return questionService.getByTest(testId, page, size, order, params).map(questionMapper::toQuestionDto);
    }

    public QuestionDto create(QuestionDto question) {
        return questionMapper.toQuestionDto(questionService.create(questionMapper.toQuestion(question)));
    }

    public QuestionDto update(QuestionDto question) {
        return questionMapper.toQuestionDto(questionService.update(questionMapper.toQuestion(question)));
    }

    public void deleteById(int id) {
        questionService.deleteById(id);
    }
}