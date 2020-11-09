/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.Data;

import java.util.List;

@Data
public class PersonalStatisticForUser {

    private String fio;
    private String nameOfTest;
    private String question;
    private int completed;
    private double percent;

}
