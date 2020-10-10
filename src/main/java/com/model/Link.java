/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long linkId;
    private String link;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "literature_id")
    private Literature literature;
}