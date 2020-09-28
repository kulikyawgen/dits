/*
@author Andrei Gorevoi
*/
package com.service.user;

import com.model.User;
import com.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User newUser) {
        userRepository.addUser(newUser);
    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.updateUser(updatedUser);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userRepository.deleteUserById(id);
    }

    @Override
    public boolean deleteUserByLogin(String login) {
        return userRepository.deleteUserByLogin(login);
    }
}
