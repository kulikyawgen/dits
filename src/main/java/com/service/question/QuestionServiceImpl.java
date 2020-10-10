package com.service.question;

import com.model.Question;
import com.repository.QuestionRepository;
import com.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestService testService;

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        return null;
    }

    @Override
    public Question getOne(int id) {
        return questionRepository.getOne(id);
    }

    @Override
    public Page<Question> getPage(int page, int size, String order, String... params) {
        return questionRepository.findAll(createPageRequest(page, size, order, params));
    }

    @Override
    public Page<Question> getByTopic(int testId, int page, int size, String order, String... params) {
        return questionRepository.findByTest(
                createPageRequest(page, size, order, params),
                testService.getOne(testId)
        );
    }

    @Override
    public void deleteById(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }

    private PageRequest createPageRequest(int page, int size, String order, String... params) {
        return PageRequest.of(page, size, Sort.Direction.fromString(order), params);
    }
}