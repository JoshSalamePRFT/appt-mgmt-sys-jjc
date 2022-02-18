package com.example.userservice.controller;

import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    //@Autowired
    private final UserService userService;

    @GetMapping("/get/{user_id}")
    public User getUser(@PathVariable("user_id") long user_id) {
        return userService.readUser(user_id);
    }

    @PostMapping("/post")
    public void postUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/put/{user_id}")
    public void putUser(@RequestBody User user, @PathVariable("user_id") long user_id) {
        userService.updateUser(user, user_id);
    }

    @DeleteMapping("/delete/{user_id}")
    public void deleteUser(@PathVariable("user_id") long user_id) {
        userService.deleteUser(user_id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.listUsers();
    }
}
