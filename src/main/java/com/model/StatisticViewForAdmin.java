package com.model;

import lombok.Data;

@Data
public class StatisticViewForAdmin {
    private String login;
    private String name;
    private int countCompleted;
    private int percent;
}
