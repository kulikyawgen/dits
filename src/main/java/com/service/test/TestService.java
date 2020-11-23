package com.service.test;

import com.model.Test;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TestService {

    Test create(Test test);

    Test update(Test test);

    Test getOne(int id);

    Page<Test> getPage(int page, int size, String order, String... params);

    Page<Test> getByTopic(int topicId, int page, int size, String order, String... params);

    List<Test> getAllTests();

    void deleteById(int id);

    Test getByName(String name);
}