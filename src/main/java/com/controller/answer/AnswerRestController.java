/*
@author Andrei Gorevoi
*/
package com.controller.answer;

import com.model.Answer;
import com.service.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answer")
public class AnswerRestController {

    private final AnswerService answerService;

    @Autowired
    public AnswerRestController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PutMapping(value = "/")
    public Answer putAnswer(@RequestBody Answer answer){
        return answerService.addAnswer(answer);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnswer(@PathVariable int id){
        answerService.deleteAnswerById(id);
    }

    @PostMapping(value = "/handler/{id}")
    public Answer getAnswerById(@PathVariable int id){
        return answerService.getAnswerById(id);
    }

    @PostMapping(value = "/all/{id}")
    public List<Answer> getAnswersForQuestion(@PathVariable int id){
        return answerService.getAllAnswersByQuestionId(id);
    }
    @PostMapping(value = "/true/{id}")
    public List<Answer> getTrueAnswersForQuestion(@PathVariable int id){
        return answerService.getTrueAnswersForQuestion(id);
    }

    @GetMapping(value = "/")
    public List<Answer> getAllAnswers(){
        return answerService.getAllAnswers();
    }
}
