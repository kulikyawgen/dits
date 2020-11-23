package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "usr")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "first_Name")
    @NotBlank(message = "NotEmpty.userForm.email")
    private String firstName;
    @Size(min = 2, max = 15,  message = "NotEmpty.userForm.lastname")
    @Column(name = "last_name")
    private String lastName;
    @NotBlank(message = "NotEmpty.userForm.login")
    private String login;
    @NotBlank(message = "NotEmpty.userForm.pass")
    private String password;
    @Transient
    @Email
    private String email;
  //  @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "usr_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

}