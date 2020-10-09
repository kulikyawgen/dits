package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int topicId;
    private String description;
    private String name;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Test> tests;
}