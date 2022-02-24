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

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    //TODO add more tests

    @Mock
    private UserService userService;

    private User user;
    private List<User> userList; //not used?

    @InjectMocks //injects the userService mock into the controller
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .user_id(1)
                .firstName("notJohn")
                .lastName("notDoe")
                .age(25)
                .gender("notMale")
                .emailAddress("notjohndoe@fakeemail.com")
                .phoneNumber("6465471234")
                .build();

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    //TODO fix post test
    @Test //currently failing. Issue with asJsonString method, not mapping phoneNumber property of User correctly.
    public void postTest() throws Exception {
        when(userService.createUser(any())).thenReturn(user);
        mockMvc.perform(post("/api/v1/user/post/") //
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isCreated());
        //Verify the controller's post method called the service's createUser method
        verify(userService,times(1)).createUser(any());
    }

    @Test
    public void getAllTest() throws Exception {
        when(userService.listUsers()).thenReturn(userList);
        mockMvc.perform(get("/api/v1/user/getAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andDo(MockMvcResultHandlers.print());

        //Verify that the service called listUsers
        verify(userService).listUsers();
        verify(userService,times(1)).listUsers();
    }

    @Test
    public void getTest() throws Exception {
        when(userService.readUser(user.getUser_id())).thenReturn(user);
        mockMvc.perform(get("/api/v1/user/get/" + user.getUser_id())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //TODO check: not sure this should be passing.
    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(delete("/api/v1/user/delete/" + user.getUser_id()))
                .andExpect(status().isNoContent())
                .andDo(MockMvcResultHandlers.print());
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