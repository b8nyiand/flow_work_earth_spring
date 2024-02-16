package hu.flowacademy.bank.controller;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.Customer;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bank")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create/{username}/account")
    public BankAccount createBankAccountForUser(@PathVariable String username, @RequestBody BankAccount bankAccount) {
        return bankAccountService.createBankAccount(username, bankAccount);
    }

    @PutMapping("/update/account")
    public BankAccount updateBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.updateBankAccount(bankAccount);
    }

    @DeleteMapping("/delete/account/{id}")
    public void deleteBankAccount(@PathVariable Long id) {
        bankAccountService.deleteBankAccount(id);
    }

    @GetMapping("/user/{username}/accounts")
    public List<BankAccount> getBankAccountsByUserName(@PathVariable String username) {
        return bankAccountService.getBankAccountsByUserName(username);
    }

    @GetMapping("/account/{id}")
    public BankAccount getBankAccountById(@PathVariable Long id) {
        return bankAccountService.getBankAccountById(id);
    }
}