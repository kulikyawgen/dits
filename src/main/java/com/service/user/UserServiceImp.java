package com.service.user;

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
        return userRepo.findByLogin(login);
    }
}
