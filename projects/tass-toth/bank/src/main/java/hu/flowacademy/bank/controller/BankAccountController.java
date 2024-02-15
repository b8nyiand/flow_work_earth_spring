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
@RequestMapping("/bankaccounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    // Get all bank account
    @GetMapping("/listAllBankAccounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.listAllBankAccounts();
    }

    // Get bank account by id
    @GetMapping("/{id}")
    public BankAccount getBankAccountById(@PathVariable Long id) {
        return bankAccountService.findByAccountId(id);
    }

    // Create new bank account
    @PostMapping("/create/{username}")
    public BankAccount createBankAccount(@PathVariable String username ,@RequestBody BankAccount bankAccount) {
        return bankAccountService.createBankAccount(username,bankAccount);
    }

    // Update existing bank account
    @PutMapping("/update/{id}")
    public BankAccount updateBankAccount (@RequestBody BankAccount bankAccount) {
        return bankAccountService.updateBankAccount(bankAccount);
    }


    // Delete bank account
    @DeleteMapping("/delete/{id}")
    public void deleteBankAccount(@PathVariable Long id) {
        bankAccountService.deleteBankAccount(id);
        }
    }
