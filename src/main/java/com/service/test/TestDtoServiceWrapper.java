package com.service.test;

import com.dto.TestDto;
import com.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestDtoServiceWrapper {

    @Autowired
    private TestService testService;
    @Autowired
    private TestMapper testMapper;

    public TestDto create(TestDto test) {
        return testMapper.toTestDto(testService.create(testMapper.toTest(test)));
    }

    public TestDto update(TestDto test) {
        return testMapper.toTestDto(testService.create(testMapper.toTest(test)));
    }

    public TestDto getOne(int id) {
        return testMapper.toTestDto(testService.getOne(id));
    }

    public Page<TestDto> getPage(int page, int size, String order, String... params) {
        return testService
                .getPage(page, size, order, params)
                .map(testMapper::toTestDto);
    }

    public Page<TestDto> getByTopic(int topicId, int page, int size, String order, String... params) {
        return testService
                .getByTopic(topicId, page, size, order, params)
                .map(testMapper::toTestDto);
    }

    public void deleteById(int id) {
        testService.deleteById(id);
    }
}