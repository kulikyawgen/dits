/*
@author Andrei Gorevoi
*/
package com.service.user;

import com.model.User;

import java.util.List;

public interface UserService {
    void addUser(User newUser);
    void updateUser(User updatedUser);
    User getUserByLogin(String login);
    User getUserById(Long id);
    List<User> getAllUsers();
    boolean deleteUserById(Long id);
    boolean deleteUserByLogin(String login);
}
