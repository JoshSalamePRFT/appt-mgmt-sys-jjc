package com.example.userservice.service;

import com.example.userservice.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User readUser(long id);
    User updateUser(User user, long id);
    void deleteUser(long id);
    List<User> listUsers();
}
