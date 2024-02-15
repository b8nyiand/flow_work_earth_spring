package hu.flowacademy.bank.controller;



import hu.flowacademy.bank.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // majd az endpointok ide
}