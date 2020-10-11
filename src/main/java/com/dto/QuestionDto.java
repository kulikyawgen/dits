package com.dto;

import lombok.Data;

@Data
public class QuestionDto {
    private int questionId;
    private String description;
    private int testId;
}