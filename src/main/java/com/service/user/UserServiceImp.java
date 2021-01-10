package com.service.user;

import com.model.User;
import com.repository.user.UserRepo;
import com.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleServiceImp;

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public void updateUser(User user) {
        userRepo.saveAndFlush(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

}
