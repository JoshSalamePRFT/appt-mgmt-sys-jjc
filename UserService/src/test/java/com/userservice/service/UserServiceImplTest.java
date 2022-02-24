package com.userservice.service;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    //TODO add tests?
    //Delete test not mocked, since the return value is null. There's nothing to check.

    @Mock
    private UserRepository userRepository;

    @Autowired
    @InjectMocks
    private UserServiceImpl userService;
    private User user1;
    private User user2;
    List<User> userList;

    @BeforeEach
    public void setUp() {
        userList = new ArrayList<>();
        user1 = User.builder()
                .user_id(1)
                .firstName("Johnny?")
                .lastName("Doe")
                .age(24)
                .gender("Male")
                .emailAddress("john.doe@fakeemail.com")
                .phoneNumber("6465491234")
                .build();

        user2 = User.builder()
                .user_id(2)
                .firstName("notJohn")
                .lastName("notDoe")
                .age(25)
                .gender("notMale")
                .emailAddress("notjohndoe@fakeemail.com")
                .phoneNumber("6465471234")
                .build();

        userList.add(user1);
        userList.add(user2);
    }

    @AfterEach
    public void tearDown() {
        user1 = user2 = null;
        userList = null;
    }

    @Test
    void createUserTest() {
        when(userRepository.save(any())).thenReturn(user1);
        userService.createUser(user1);
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void readUserTest() {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
        /* check that user object is the same as what you asked it to get by ID.
           Will fail if you don't create the original user with an ID in this test,
           because calling its getUser_id() method would return 0 (or null?, whichever is the default for a long),
           but the auto-generated one will have an ID of 1, and get a mismatch.
        */
        assertThat(userService.readUser(user1.getUser_id())).isEqualTo(user1);
    }

    @Test
    void updateUserTest() {
        //TODO create test
    }

    //TODO fix test
    //TODO split test for happy path + exception for value not present
    @Test
    void deleteUserTest() {
        //Use when method to indicate the return value, even for 'null' value.
        //when(userRepository.)
        //Only testing delete service function, so service is bypassed and repo is called directly.
        userRepository.save(user1);
        //Test service delete function. Just checks that it doesn't throw an error
        userService.deleteUser(user1.getUser_id());
        //Use an assert to check the return value is correct.
    }

    @Test
    void listUsersTest() {
        userRepository.save(user1);

        //stubbing mock to return specific data
        when(userRepository.findAll()).thenReturn(userList);

        //service method call
        List<User> userList1 = userService.listUsers();

        //check return value is correct
        assertEquals(userList1, userList);

        //Make sure the save call worked properly
        verify(userRepository, times(1)).save(user1);
        //Make sure that when the listUsers() method was called from the service, it called findAll in the repository
        verify(userRepository, times(1)).findAll();
    }
}