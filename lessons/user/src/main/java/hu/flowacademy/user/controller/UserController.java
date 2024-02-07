package hu.flowacademy.user.controller;

import hu.flowacademy.user.model.User;
import hu.flowacademy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUSer(id);
    }

    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/listByName/{name}")
    public List<User> listUsersByName(@PathVariable String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/listUsersPoints/{point}")
    public List<User> getUsersGreaterThan(@PathVariable int point) {
        return userService.getUsersGreaterThanPoints(point);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
