package service;

import model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User readUser(long id);
    void updateUser(User user, long id);
    void deleteUser(long id);
    List<User> listUsers();
}
