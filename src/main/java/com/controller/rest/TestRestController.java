package com.controller.rest;

import com.dto.TestDto;
import com.service.test.TestDtoServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestRestController {

    @Autowired
    private TestDtoServiceWrapper testDtoService;

    @GetMapping("{id}")
    public TestDto getOne(@PathVariable int id) {
        return testDtoService.getOne(id);
    }

    @GetMapping
    public Page<TestDto> getPage(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "7") int size,
                                 @RequestParam(required = false, defaultValue = "ASC") String order,
                                 @RequestParam(required = false, defaultValue = "name") String... params) {
        return testDtoService.getPage(page, size, order, params);
    }

    @GetMapping("/topic")
    public Page<TestDto> findByTopic(@RequestParam int id,
                                     @RequestParam(required = false, defaultValue = "0") int page,
                                     @RequestParam(required = false, defaultValue = "7") int size,
                                     @RequestParam(required = false, defaultValue = "ASC") String order,
                                     @RequestParam(required = false, defaultValue = "name") String... params) {
        return testDtoService.getByTopic(id, page, size, order, params);
    }

    @PostMapping
    public TestDto create(@RequestBody TestDto testDto) {
        return testDtoService.create(testDto);
    }

    @PatchMapping
    public TestDto update(@RequestBody TestDto testDto) {
        return testDtoService.update(testDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        testDtoService.deleteById(id);
    }
}