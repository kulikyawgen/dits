package com.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "topic_id")
    private int topicId;
    private String description;
    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Test> tests;
}