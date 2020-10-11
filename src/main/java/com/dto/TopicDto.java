package com.dto;

import lombok.Data;

import java.util.List;

@Data
public class TopicDto {
    private int topicId;
    private String name;
    private String description;
    public List<TestDto> tests;
}