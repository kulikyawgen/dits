package com.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private int answerId;
    private String description;
    private boolean correct;
    private int questionId;
}