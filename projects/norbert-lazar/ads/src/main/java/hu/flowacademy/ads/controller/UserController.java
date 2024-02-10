package hu.flowacademy.ads.controller;

import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PatchMapping
    @RequestMapping("/modify")
    public User modifyUser(@RequestBody User user) {
        return userService.modifyUser(user);
    }

    @DeleteMapping
    @RequestMapping("/{userName}/delete")
    public void deleteUserByUserName(@PathVariable String userName){
        userService.deleteUser(userName);
    }

    @GetMapping
    @RequestMapping("/list")
    public List<User> listAllUser(){
        return userService.listAllUser();
    }

    @GetMapping
    @RequestMapping("/{userName}/list")
    public User userByUserName(@PathVariable String userName){
        return userService.listUserByUserName(userName);
    }

}
