package com.controller.rest;

import com.dto.AnswerDto;
import com.service.answer.AnswerDtoServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {

    @Autowired
    private AnswerDtoServiceWrapper answerDtoService;

    @GetMapping("{id}")
    public AnswerDto getOne(@PathVariable int id) {
        return answerDtoService.getAnswerById((long) id);
    }

    @GetMapping
    public List<AnswerDto> getAll() {
        return answerDtoService.getAllAnswers();
    }

    @GetMapping("/question")
    public List<AnswerDto> getByQuestionId(@RequestParam int id) {
        return answerDtoService.getAllAnswersByQuestionId(id);
    }

    @PostMapping
    public void create(@RequestBody AnswerDto answerDto) {
        answerDtoService.addAnswer(answerDto);
    }

    @PatchMapping
    public void update(@RequestBody AnswerDto answerDto) {
        answerDtoService.updateAnswer(answerDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        answerDtoService.deleteAnswerById((long) id);
    }
}