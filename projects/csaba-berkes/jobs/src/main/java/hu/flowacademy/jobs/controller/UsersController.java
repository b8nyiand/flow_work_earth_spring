package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.modell.Users;
import hu.flowacademy.jobs.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userpanel")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/adduser")
    public Users addUser(@RequestBody Users users){
        return usersService.addUser(users);
    }
    @PutMapping("/updateuser")
    public Users updateUser(Users users){
        return usersService.updateUser(users);
    }
}
