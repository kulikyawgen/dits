package com.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Static implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staticId")
    private Long staticId;
    private Date date;
    private boolean correct;
//    @ManyToOne
//    @JoinColumn(name = "questionId")
//    private Question question;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Static() {
    }

    public Long getStaticId() {
        return staticId;
    }

    public void setStaticId(Long staticId) {
        this.staticId = staticId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
