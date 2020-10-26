package com.service.user;

import com.model.Link;
import com.model.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);

    void addUser(User user);

    void delete(User user);

    void updateUser(User user);

    User getUserById(Integer id);

    List<User> getAllUser();

    void createUser(User user);
}
