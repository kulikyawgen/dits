package com.service;

import com.model.User;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public User findByLogin(String login) {
        User byLogin = userRepo.findByLogin(login);
        return byLogin;
    }
}
