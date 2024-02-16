package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{userName}")
    public void deleteUser(@PathVariable String userName) {
        userService.deleteUser(userName);
    }

    @PutMapping("/updateUser")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/listByUserName/{userName}")
    public List<User> listUsersByUserName(@PathVariable String userName) {
        return userService.listUsersByUserName(userName);
    }

    @GetMapping("/listAllUsers")
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }
}
