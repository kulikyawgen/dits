/*
@author Andrei Gorevoi
*/
package com.model;

import lombok.Data;

@Data
public class AppUser {

    private int id;
    private String firstName;
    private String lastName;
    private String login;


    public static AppUser convertToAppUser(User user){
        AppUser appUser = new AppUser();
        appUser.setId(user.getUserId());
        appUser.setFirstName(user.getFirstName());
        appUser.setLastName(user.getLastName());
        appUser.setLogin(user.getLogin());
        return appUser;
    }

}
