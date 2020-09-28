/*
@author Andrei Gorevoi
*/
package com.service.test;

import com.model.Test;

import java.util.List;

public interface TestService {
    void addTest(Test newTest);
    void deleteTestById(Long id);
    void deleteTestByName(String name);
    void updateTest(Test updatedTest);
    Test getTestById(Long id);
    Test getTestByName(String name);
    List<Test> getAllTests();
    List<Test> getAllTestsByTopicId(Long id);
}
