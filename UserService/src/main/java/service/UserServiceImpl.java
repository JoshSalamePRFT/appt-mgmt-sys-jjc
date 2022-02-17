package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {


    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User readUser(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void updateUser(User user, long id) {
        User oldUser = userRepository.getById(id);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setGender(user.getGender());
        oldUser.setAge(user.getAge());
        oldUser.setEmailAddress(user.getEmailAddress());
        oldUser.setPhoneNumber(user.getPhoneNumber());

        userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
