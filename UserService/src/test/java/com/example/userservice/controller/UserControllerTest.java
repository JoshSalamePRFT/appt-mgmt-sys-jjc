package com.example.userservice.controller;

import com.example.userservice.model.User;
import org.h2.engine.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {
    //TODO

    @Autowired
    private UserController userController;

    @BeforeEach
    void setUp() {

    }

    //make dependent on post perhaps?
    @Test
    void getUser() {
        //Test requires DB to have values, so run post first to ensure this.
        long user_id = 1;
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .gender("Male")
                .emailAddress("johndoe@fakemail.com")
                .phoneNumber("123-456-7890")
                .build();
        userController.postUser(user);

        userController.getUser(user_id);
    }

    @Test
    void postUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .gender("Male")
                .emailAddress("johndoe@fakemail.com")
                .phoneNumber("123-456-7890")
                .build();

        userController.postUser(user);
    }

    //make dependent on post perhaps?
    @Test
    void putUser() {
        //Test requires DB to have values, so run post first to ensure this.
        postUser();

        long user_id = 1;
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .gender("Male")
                .emailAddress("johndoe@fakemail.com")
                .phoneNumber("123-456-7890")
                .build();

        userController.putUser(user, user_id);
    }

    //make dependent on post perhaps?
    @Test
    void deleteUser() {
        //Test requires DB to have values, so run post first to ensure this.
        postUser();

        long user_id = 1;
        userController.deleteUser(user_id);
    }

    @Test
    void getAllUsers() {
        userController.getAllUsers();
    }
}