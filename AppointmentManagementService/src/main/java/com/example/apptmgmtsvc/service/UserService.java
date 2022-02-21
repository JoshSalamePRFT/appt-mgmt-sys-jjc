package com.example.apptmgmtsvc.service;


import com.example.apptmgmtsvc.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User readUser(long id);
    User updateUser(User user, long id);
    void deleteUser(long id);
    List<User> listUsers();
}
