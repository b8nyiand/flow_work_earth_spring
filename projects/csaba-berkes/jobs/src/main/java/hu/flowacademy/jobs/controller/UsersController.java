package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.modell.Users;
import hu.flowacademy.jobs.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userpanel")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/adduser")
    public Users addUser(@RequestBody Users users) {
        return usersService.addUser(users);
    }

    @PutMapping("/updateuser")
    public Users updateUser(Users users) {
        return usersService.updateUser(users);
    }

    @DeleteMapping("/deleteuser/{username}")
    public void deleteUser(Users username) {
        usersService.deleteUser(username);
    }

    @GetMapping("/findByName/{fullname}")
    public List<Users> findByFullname(@PathVariable String fullname) {
        return usersService.findByFullname(fullname);
    }
    @GetMapping("/userlist")
    public List<Users> listAllUsers(){
        return usersService.usersList();
    }
    @GetMapping("/molnar")
    public List<Users> findByFullnameLike(){
        return usersService.findByFullnameLike();
    }
}
