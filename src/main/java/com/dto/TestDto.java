package com.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestDto {

    private int testId;
    private String name;
    private String description;
    private List<QuestionDto> questions;
    private int topicId;
}