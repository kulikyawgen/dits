package com.dto;

import com.model.Answer;
import lombok.Data;

@Data
public class AnswerDto {
    private int answerId;
    private String description;
    private boolean correct;
    private int questionId;

    public AnswerDto convertToDtro(Answer answer){
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(answer.getAnswerId());
        answerDto.setDescription(answer.getDescription());
        answerDto.setCorrect(answer.isCorrect());
        return answerDto;
    }
}