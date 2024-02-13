package hu.flowacademy.bank.controller;


import hu.flowacademy.bank.model.AccountOwner;
import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    @Autowired
    public BankAccountService bankAccountService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccount addNewAccount(@RequestBody BankAccount bankAccount, @RequestParam String userName) {
        return bankAccountService.addNewAccount(bankAccount, userName);
    }

    @PutMapping("/update")
    public BankAccount updateAccount(@RequestBody BankAccount account, @RequestParam String userName, @RequestParam Long id) {
        return bankAccountService.updateAccount(account, userName, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccountById(@PathVariable Long id) {
        bankAccountService.deleteAccountById(id);
    }

    @GetMapping("/listByUserName/{userName}")
    public List<BankAccount> accountList(@PathVariable String userName) {
        return bankAccountService.accountList(userName);
    }

    @GetMapping("/findById/{id}")
    public BankAccount findById(@PathVariable Long id) {
        return bankAccountService.findById(id);
    }

}
