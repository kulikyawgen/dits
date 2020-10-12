package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Question {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    private String description;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @OneToMany(mappedBy = "questionid")
    private List<Answer> answers;
}