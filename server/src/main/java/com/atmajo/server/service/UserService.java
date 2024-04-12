package com.atmajo.server.service;

import com.atmajo.server.model.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);
    public void updateUser(Long enrollment, User user);
    public void deleteUser(Long enrollment);
    public User getUser(Long enrollment, String password);
    public List<User> getAllUser();

}
