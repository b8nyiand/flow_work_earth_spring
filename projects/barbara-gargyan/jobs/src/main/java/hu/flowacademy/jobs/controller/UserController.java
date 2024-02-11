package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    @GetMapping("/listByUserName/{userName}")
    public List<User> getUsersByUsersName(@PathVariable String userName) {
        return userService.getUsersByUserName(userName);
    }

    @GetMapping("/allUserList")
    public List<User> allUserList() {
        return userService.allUserList();
    }


}
