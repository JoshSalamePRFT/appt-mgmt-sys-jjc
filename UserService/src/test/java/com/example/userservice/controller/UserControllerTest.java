package com.example.userservice.controller;

import com.example.userservice.model.User;
//import com.example.userservice.phoneHandling.PhoneNumber;
//import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    //TODO

    @Autowired
    private UserController userController;

    @BeforeEach
    void setUp() {

    }

    //make dependent on post perhaps?
    @Test
    void getUser(@Autowired MockMvc mockMvc) throws Exception {
        //mockMvc.perform(getUser());
    }

    @Test
    void postUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .gender("Male")
                .emailAddress("johndoe@fakemail.com")
                //.phoneNumber(new PhoneNumber().setRawInput("123-456-7890"))
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
                //.phoneNumber(new PhoneNumber().setRawInput("123-456-7890"))
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