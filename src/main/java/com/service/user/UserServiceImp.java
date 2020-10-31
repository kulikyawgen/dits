package com.service.user;

import com.model.Link;
import com.model.User;
import com.repository.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public void updateUser(User user) {userRepo.saveAndFlush(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public void createUser(User user) {

    }


}
