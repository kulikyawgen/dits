/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String login;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "userid",referencedColumnName = "userid"),
    inverseJoinColumns = @JoinColumn(name = "roleid",referencedColumnName = "roleid"))
    //TODO joincolums
    private List<Role> roles;
}
