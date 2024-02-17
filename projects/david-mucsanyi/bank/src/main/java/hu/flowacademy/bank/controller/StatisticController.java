package hu.flowacademy.bank.controller;


import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.service.BankAccountService;
import hu.flowacademy.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stats")
@RestController
public class StatisticController {

    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private UserService userService;

    @GetMapping("/findbyId/{id}")
    public Class<BankAccountService> findbyId(@PathVariable Long id) {
        return BankAccountService.class;
    }


    @GetMapping("/listUsersPoints/{points}")
    public BankAccount findbyBalance(@PathVariable int balance) {
        return userService.findbyBalance();
    }

}
