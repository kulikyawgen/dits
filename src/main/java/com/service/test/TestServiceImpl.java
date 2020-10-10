package com.service.test;

import com.model.Test;
import com.repository.TestRepository;
import com.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TopicService topicService;

    @Override
    public Test create(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test update(Test test) {
        return null;
    }

    @Override
    public Test getOne(int id) {
        return testRepository.getOne(id);
    }

    @Override
    public Page<Test> getPage(int page, int size, String order, String... params) {
        return testRepository.findAll(createPageRequest(page, size, order, params));
    }

    @Override
    public Page<Test> getByTopic(int topicId, int page, int size, String order, String... params) {
        return testRepository.findByTopic(
                createPageRequest(page, size, order, params),
                topicService.getOne(topicId));
    }

    @Override
    public void deleteById(int id) {
        testRepository.deleteById(id);
    }

    @Override
    public void delete(Test test) {
        testRepository.delete(test);
    }

    private PageRequest createPageRequest(int page, int size, String order, String... params) {
        return PageRequest.of(page, size, Sort.Direction.fromString(order), params);
    }
}