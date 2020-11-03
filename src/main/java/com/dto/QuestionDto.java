package com.dto;

import com.model.Answer;
import com.model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class QuestionDto {
    private int questionId;
    private String description;
    private int testId;
    private boolean answered=false;
    private Date dateOfAnswered;
    private List<AnswerDto> answers;


    public QuestionDto convertToDto(Question question, List<Answer> answersForQuestion){
        QuestionDto questionDto = new QuestionDto();
        List<AnswerDto> answerDtoList = new ArrayList<>();
        questionDto.setQuestionId(question.getQuestionId());
        questionDto.setDescription(question.getDescription());
        questionDto.setTestId(question.getTest().getTestId());
        questionDto.setAnswered(false);
        for (Answer answer : answersForQuestion) {
            AnswerDto answerDto = new AnswerDto();
            answerDto = answerDto.convertToDtro(answer);
            answerDtoList.add(answerDto);
        }
        questionDto.setAnswers(answerDtoList);
        return questionDto;
    }
}