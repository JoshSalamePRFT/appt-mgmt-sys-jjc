package com.jjcperf.userservice.controller;

//CREDIT TO SPRINGFRAMEWORKGURU: https://springframework.guru/testing-spring-boot-restful-services/

import com.jjcperf.userservice.model.User;
import com.jjcperf.userservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    //TODO add missing tests: getApptById.
    //TODO add tests for unhappy paths for: get, post, put, delete, getAll, getApptById

    @Mock
    private UserService userService;

    private User user;
    private User user2;
    private List<User> userList;

    @InjectMocks //injects the userService mock into the controller
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .user_id(3)
                .firstName("notJohn")
                .lastName("notDoe")
                .age(25)
                .gender("notMale")
                .emailAddress("notjohndoe@fakeemail.com")
                .phoneNumber("6465471234")
                .build();

        user2 = User.builder()
                .user_id(45)
                .firstName("John")
                .lastName("Doe")
                .age(63)
                .gender("Male")
                .emailAddress("johndoe@fakeemail.com")
                .phoneNumber("6465477890")
                .build();

        userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @AfterEach
    void tearDown() {
        user = null;
        user2 = null;
        userList = null;
    }

    @Test
    public void getTest() throws Exception {
        when(userService.readUser(user.getUser_id())).thenReturn(user);
        mockMvc.perform(get("/api/v1/user/get/" + user.getUser_id()))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(user)))
                .andDo(MockMvcResultHandlers.print());

        verify(userService, times(1)).readUser(user.getUser_id());
    }

    @Test
    public void postTest() throws Exception {
        when(userService.createUser(any())).thenReturn(user);

        String jsonContent = asJsonString(user); //expected returned content

        mockMvc.perform(post("/api/v1/user/post/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isCreated())
                .andExpect(content().json(jsonContent))
                .andDo(MockMvcResultHandlers.print());

        verify(userService,times(1)).createUser(any());
    }

    @Test
    public void putTest() throws Exception {
        long id = 3;

        when(userService.updateUser(any(), eq(id))).thenReturn(user);

        String jsonContent = asJsonString(user); //expected returned content

        mockMvc.perform(put("/api/v1/user/put/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonContent))
                .andDo(MockMvcResultHandlers.print());

        verify(userService,times(1)).updateUser(any(), eq(id));
    }

    @Test
    public void deleteTest() throws Exception {
        doNothing().when(userService).deleteUser(user.getUser_id());
        mockMvc.perform(delete("/api/v1/user/delete/" + user.getUser_id()))
                .andExpect(status().isNoContent())
                .andDo(MockMvcResultHandlers.print());

        verify(userService, times(1)).deleteUser(user.getUser_id());
    }

    @Test
    public void getAllTest() throws Exception {
        when(userService.listUsers()).thenReturn(userList);
        mockMvc.perform(get("/api/v1/user/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(userList)))
                .andDo(MockMvcResultHandlers.print());

        verify(userService,times(1)).listUsers();
    }

    //Might need to create a custom mapper because of the phoneNumber property
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}