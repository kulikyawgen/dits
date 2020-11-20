package com.service.user;

import com.model.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);

    User addUser(User user);

    void delete(User user);

    void updateUser(User user);

    User getUserById(Integer id);

    List<User> getAllUser();

    void createUser(User user);
}
