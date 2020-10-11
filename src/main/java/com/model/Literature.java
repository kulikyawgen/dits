/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Literature {
    @Id
    @Column(name = "literature_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int literatureId;

    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    Question questionid;
}
