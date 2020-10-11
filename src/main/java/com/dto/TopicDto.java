package com.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TopicDto {
    private int id;
    private String name;
    private String description;
}