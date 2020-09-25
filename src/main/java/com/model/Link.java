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
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long linkid;

    @Column
    private String link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "literatureid")
    private Literature literature;
}
