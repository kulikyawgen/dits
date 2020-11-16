package com.service.test;

import com.mapper.TestMapper;
import com.model.Test;
import com.model.Topic;
import com.model.ViewStatistic;
import com.repository.test.TestRepository;
import com.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TopicService topicService;
    @Autowired
    private TestMapper testMapper;

    @Override
    public Test create(Test test) {
        test.setTestId(0);
        Topic parent = topicService.getOne(test.getTopic().getTopicId());
        parent.addTest(test);
        return testRepository.save(test);
    }

    @Override
    public Test update(Test test) {
        Test fromDB = getOne(test.getTestId());
        testMapper.update(test, fromDB);
        return testRepository.save(fromDB);
    }

    @Override
    public Test getOne(int id) {
        return testRepository.findById(id).orElse(null);
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
    public List<Test> getAllTests() {
        List<Test> all = testRepository.findAll();
        return all;
    }

    @Override
    public void deleteById(int id) {
        testRepository.deleteById(id);
    }


    private PageRequest createPageRequest(int page, int size, String order, String... params) {
        return PageRequest.of(page, size, Sort.Direction.fromString(order), params);
    }
}