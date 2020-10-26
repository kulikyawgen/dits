package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToMany(mappedBy = "questionid", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Answer> answers;

    public void addAnswer(Answer answer) {
        answer.setQuestionid(this);
        this.answers.add(answer);
    }
}