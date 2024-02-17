package hu.flowacademy.bank.controller;


import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.CurrencyType;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/bycurrency")
    public List<BankAccount> getAccountsByCurrency(@RequestParam CurrencyType currency) {
        return bankAccountService.getAccountsByCurrency(currency);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccount addBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.addBankAccount(bankAccount);
    }

    @PutMapping("/update")
    public List<BankAccount> listBankAccounts() {
        return bankAccountService.findAllBankAccount();
    }

    @GetMapping("/findById/{id}")
    public BankAccount findBankAccountById(@PathVariable Long id) {
        return (BankAccount) bankAccountService.findBankAccountById(id);
    }


    @GetMapping("/findByName/{name}")
    public  List<BankAccount> findBankAccountsByName(@PathVariable String name) {
        return bankAccountService.findBankAccountsByName();
    }


    @DeleteMapping("delete/{id}")
    public void deleteBankAccount(@PathVariable Long id) {
        bankAccountService.deleteById(id);
    }

    @PutMapping("/updateBankAccount")
    public BankAccount updateBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.updateBankAccount(bankAccount);
    }

}
