package com.service.user;

import com.model.User;

public interface UserService {
    User findByLogin(String login);
}
