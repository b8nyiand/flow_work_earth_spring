package hu.flowacademy.bank.controller;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create/{userName}/account")
    public BankAccount createBankAccountForUser(@PathVariable String userName, @RequestBody BankAccount bankAccount) {
        return bankAccountService.createBankAccountForUser(userName, bankAccount);
    }

    @PutMapping("/update/account")
    public BankAccount updateBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.updateBankAccount(bankAccount);
    }

    @DeleteMapping("/delete/account/{id}")
    public void deleteBankAccount(@PathVariable Long id) {
        bankAccountService.deleteBankAccount(id);
    }

    @GetMapping("/user/{userName}/accounts")
    public List<BankAccount> getBankAccountsByUserName(@PathVariable String userName) {
        return bankAccountService.getBankAccountsByUserName(userName);
    }

    @GetMapping("/account/{id}")
    public BankAccount getBankAccountById(@PathVariable Long id) {
        return bankAccountService.getBankAccountById(id);
    }
}
