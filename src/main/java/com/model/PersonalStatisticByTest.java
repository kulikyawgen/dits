/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.Data;

import java.util.List;

@Data
public class PersonalStatisticByTest {

    private String nameOfQuestion;
    private boolean correct;
    private List<Literature> literature;
    private List<Link> linkToLiterature;

}
