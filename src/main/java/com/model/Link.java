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
    @Column(name = "link_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int linkId;

    @Column
    private String link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "literature_id")
    private Literature literatureid;
}
