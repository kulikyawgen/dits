package com.controller.rest;

import com.dto.QuestionDto;
import com.service.question.QuestionDtoServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {

    @Autowired
    private QuestionDtoServiceWrapper questionDtoService;

    @GetMapping("{id}")
    public QuestionDto getOne(@PathVariable int id) {
        return questionDtoService.getOne(id);
    }

    @GetMapping
    public Page<QuestionDto> getPage(@RequestParam(required = false, defaultValue = "0") int page,
                                     @RequestParam(required = false, defaultValue = "7") int size,
                                     @RequestParam(required = false, defaultValue = "ASC") String order,
                                     @RequestParam(required = false, defaultValue = "questionId") String... params) {
        return questionDtoService.getPage(page, size, order, params);
    }

    @GetMapping("/test")
    public Page<QuestionDto> getByTests(@RequestParam int id,
                                        @RequestParam(required = false, defaultValue = "0") int page,
                                        @RequestParam(required = false, defaultValue = "7") int size,
                                        @RequestParam(required = false, defaultValue = "ASC") String order,
                                        @RequestParam(required = false, defaultValue = "questionId") String... params) {
        return questionDtoService.getByTest(id, page, size, order, params);
    }

    @PostMapping
    public QuestionDto create(@RequestBody QuestionDto question) {
        return questionDtoService.create(question);
    }

    @PatchMapping
    public QuestionDto update(@RequestBody QuestionDto question) {
        return questionDtoService.update(question);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        questionDtoService.deleteById(id);
    }
}