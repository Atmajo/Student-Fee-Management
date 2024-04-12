package com.atmajo.server.service.impl;

import com.atmajo.server.model.User;
import com.atmajo.server.repository.UserRepo;
import com.atmajo.server.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(Long enrollment, User user) {
        Optional<User> optionalUser = userRepo.findById(enrollment);
        if (optionalUser.isPresent()){
            userRepo.save(user);
        }
        else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUser(Long enrollment) {
        userRepo.deleteById((enrollment));
    }

    @Override
    public User getUser(Long enrollment, String password) {
        User user = userRepo.findById((enrollment)).get();
        BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();

        if(!decoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
