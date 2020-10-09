package com.service;

import com.model.User;

public interface UserService {
    User findByLogin(String login);
}
