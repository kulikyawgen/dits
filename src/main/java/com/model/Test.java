package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_id")
    private int testId;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic_id")
    private Topic topic;
    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Question> questions;

    public void addQuestion(Question question) {
        question.setTest(this);
        this.questions.add(question);
    }
}