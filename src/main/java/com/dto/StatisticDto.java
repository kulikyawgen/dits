package com.dto;

import lombok.Data;

@Data
public class StatisticDto {
    private String login;
    private String name;
    private int countCompleted;
    private int percent;
}
