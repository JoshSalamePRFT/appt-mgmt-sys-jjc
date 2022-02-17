package controller;

import model.User;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController("api/v1")
public class UserController {

    private UserService userService;

    @GetMapping("/get")
    public User getUser(long id) {
        return userService.readUser(id);
    }

    @PostMapping("/post")
    public void postUser(User user) {
        userService.createUser(user);
    }

    @PutMapping("/put")
    public void putUser(User user, long id) {
        userService.updateUser(user, id);
    }

    @DeleteMapping("/delete")
    public void deleteUser(long id) {
        userService.deleteUser(id);
    }

    @GetMapping("getAll")
    public List<User> getAllUsers() {
        return userService.listUsers();
    }
}
