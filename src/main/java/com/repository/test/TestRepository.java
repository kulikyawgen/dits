/*
@author Andrei Gorevoi
*/
package com.repository.test;

import com.model.Test;

import java.util.List;

public interface TestRepository {
    void addTest(Test newTest);
    void deleteTestById(Long id);
    void deleteTestByName(String name);
    void updateTest(Test updatedTest);
    Test findTestById(Long id);
    Test findTestByName(String name);
    List<Test> findAllTests();
    List<Test> findAllTestsByTopicId(Long id);
}
