package com.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private int questionId;
    private String description;
    private int testId;
    private List<AnswerDto> answers;
}