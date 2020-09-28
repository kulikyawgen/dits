/*
@author Andrei Gorevoi
*/
package com.service.test;

import com.model.Test;
import com.repository.test.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void addTest(Test newTest) {
        testRepository.addTest(newTest);

    }

    @Override
    public void deleteTestById(Long id) {
        testRepository.deleteTestById(id);
    }

    @Override
    public void deleteTestByName(String name) {
        testRepository.deleteTestByName(name);
    }

    @Override
    public void updateTest(Test updatedTest) {
        testRepository.updateTest(updatedTest);
    }

    @Override
    public Test getTestById(Long id) {
        return testRepository.findTestById(id);
    }

    @Override
    public Test getTestByName(String name) {
        return testRepository.findTestByName(name);
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAllTests();
    }

    @Override
    public List<Test> getAllTestsByTopicId(Long id) {
        return testRepository.findAllTestsByTopicId(id);
    }
}
