package com.jjcperf.userservice.service;

import com.jjcperf.userservice.model.User;
import com.jjcperf.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User readUser(long user_id) {
        return userRepository.findById(user_id).orElseThrow();
    }

    @Override
    public User updateUser(User user, long user_id) {
        //Check whether that entry actually exists. If not, throw an error.
        User oldUser = userRepository.findById(user_id).orElseThrow();

        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setGender(user.getGender());
        oldUser.setAge(user.getAge());
        oldUser.setEmailAddress(user.getEmailAddress());
        oldUser.setPhoneNumber(user.getPhoneNumber());

        return userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(long user_id) {
        //Check whether that entry actually exists. If not, throw an error.
        userRepository.findById(user_id).orElseThrow();
        userRepository.deleteById(user_id);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
