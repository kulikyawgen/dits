/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statisticid;

    @Column
    private Date date;

    @Column
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userid;

    @ManyToOne
    @JoinColumn(name = "questionid")
    private Question questionid;


}
