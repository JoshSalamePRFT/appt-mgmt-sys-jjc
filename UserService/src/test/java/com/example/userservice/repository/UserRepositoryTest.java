package com.example.userservice.repository;


import com.example.userservice.model.User;
import com.example.userservice.phoneHandling.PhoneNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest()
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    private long id;
    private User user;

    @BeforeEach
    @Transactional
    public void setup() {
        this.user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .age(24)
                .gender("Male")
                .emailAddress("john.doe@fakeemail.com")
                .phoneNumber(new PhoneNumber("6465491234", "US"))
                .build();

        userRepository.save(this.user);
        this.id = this.user.getUser_id();
    }

    @Test
    @Transactional
    public void saveUserTest() {
        Assertions.assertThat(this.user.getUser_id()).isEqualTo(this.id);
    }

    @Test
    @Transactional
    public void getUserTest() {
        this.user = userRepository.getById(this.id);

        Assertions.assertThat(this.user.getUser_id()).isEqualTo(this.id);
    }

    @Test
    @Transactional
    public void updateUserTest() {
        this.user = User.builder()
                .user_id(this.id)
                .firstName("notJohn")
                .lastName("notDoe")
                .age(25)
                .gender("notMale")
                .emailAddress("notjohndoe@fakeemail.com")
                .phoneNumber(new PhoneNumber("6465471234", "US"))
                .build();

        userRepository.save(this.user);

        Assertions.assertThat(this.user.getUser_id()).isEqualTo(this.id);
    }

    @Test
    @Transactional
    public void deleteUserTest() {
        userRepository.deleteById(this.id);

        Assertions.assertThat(userRepository.findById(this.id).isPresent()).isFalse();
    }

    @Test
    @Transactional
    public void getAllUsersTest() {
        //TODO create proper test
        //userRepository.findAll();
        //Assertions.assert
    }
}
