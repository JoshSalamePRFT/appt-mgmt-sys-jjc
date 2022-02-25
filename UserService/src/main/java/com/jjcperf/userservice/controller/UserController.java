package com.jjcperf.userservice.controller;

import com.jjcperf.userservice.model.User;
import com.jjcperf.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired //autowired doesn't seem necessary?
    private final UserService userService;

    @GetMapping("/get/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("user_id") long user_id) {
        return userService.readUser(user_id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(
//            @Valid
            @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/put/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User putUser(
//            @Valid
            @RequestBody User user, @PathVariable("user_id") long user_id) {
        return userService.updateUser(user, user_id);
    }

    @DeleteMapping("/delete/{user_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("user_id") long user_id) {
        userService.deleteUser(user_id);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.listUsers();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> validationError(MethodArgumentNotValidException ex) {
        List<String> exceptions = new ArrayList<>();

        ex.getFieldErrors().forEach(fieldError -> {
            exceptions.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
                });
        return exceptions;
    }
}
