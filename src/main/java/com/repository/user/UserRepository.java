/*
@author Andrei Gorevoi
*/
package com.repository.user;

import com.model.User;

import java.util.List;

public interface UserRepository {
    void addUser(User newUser);
    void updateUser(User updatedUser);
    User findUserByLogin(String login);
    User findUserById(Long id);
    List<User> findAllUsers();
    boolean deleteUserById(Long id);
    boolean deleteUserByLogin(String login);

}
