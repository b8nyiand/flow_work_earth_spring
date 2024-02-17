package hu.flowacademy.bank.controller;


import hu.flowacademy.bank.model.User;
import hu.flowacademy.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/listUser")
    public List<User> listUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/listByName/{name}")
    public List<User> listUsersByName(@PathVariable String name) {
        return userService.findByUsername(name);
    }


    @PutMapping("/update")
    public User updateUser(@RequestBody User users) {
        return userService.updateUser(users);
    }

}
