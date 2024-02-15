package hu.flowacademy.bank.controller;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bank/account/")
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    //---------------------------------------------------------------------------//

    @PostMapping("/add")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    //---------------------------------------------------------------------------//

    @GetMapping("/findAll")
    public List<BankAccount> findAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/findByUsername/{username}")
    public List<BankAccount> findByBankUserUsername(@PathVariable String username) {
        return bankAccountService.findByBankUserUsername(username);
    }

    @GetMapping("/findByFullname/{fullname}")
    public List<BankAccount> findByBankUserFullname(@PathVariable String fullname) {
        return bankAccountService.findByBankUserFullname(fullname);
    }

    @GetMapping("/findById/{id}")
    public BankAccount findById(@PathVariable Long id) {
        return bankAccountService.findById(id);
    }

    //---------------------------------------------------------------------------//

    @PutMapping("/update")
    public BankAccount update(@RequestBody BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    //---------------------------------------------------------------------------//

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        bankAccountService.deleteById(id);
    }


    //---------------------------------------------------------------------------//


}
