package com.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TestDto {

    private int testId;
    @Size(min = 2, message = "NotEmpty.testForm.name")
    private String name;
    @Size(min = 2, message = "NotEmpty.testForm.description")
    private String description;
    private List<QuestionDto> questions;
    private int topicId;
}