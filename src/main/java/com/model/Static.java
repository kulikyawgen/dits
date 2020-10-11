package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "statistic")
@Data
public class Static {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staticId;
    private Date date;
    private boolean correct;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}