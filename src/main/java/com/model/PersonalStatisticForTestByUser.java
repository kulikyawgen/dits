/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.Data;

@Data
public class PersonalStatisticForTestByUser {

    private String nameOfQuestion;
    private boolean correct;
    private String literature;
    private String linkToLiterature;

}
