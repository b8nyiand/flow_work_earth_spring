package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/find-by-name/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/find-all-users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/delete-user/{name}")
    public void deleteUser(@PathVariable String name) {
        userService.deleteUserByName(name);

    }

    @PutMapping("/update-user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
