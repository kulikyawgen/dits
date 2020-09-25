/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long testid;

    @Column
    private String description;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "topicid")
    private Topic topicid;

}
