/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long literatureId;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    Question question;
}