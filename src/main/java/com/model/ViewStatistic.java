package com.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ViewStatistic {
    private String login;
    private String name;
    private int countCompleted;
    private int percent;


}
