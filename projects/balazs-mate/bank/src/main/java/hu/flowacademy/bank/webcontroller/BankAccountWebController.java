package hu.flowacademy.bank.webcontroller;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/bank/account/")

public class BankAccountWebController {


    @Autowired
    BankAccountService bankAccountService;

    //    //---------------------------------------------------------------------------//
//
//    @PostMapping("/add")
//    public BankAccount save(@RequestBody BankAccount bankAccount) {
//        return bankAccountService.save(bankAccount);
//    }
//
//    //---------------------------------------------------------------------------//
//
    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("bankaccounts", bankAccountService.findAll());
        return "accounts";
    }
//
//    @GetMapping("/findByUsername/{username}")
//    public List<BankAccount> findByBankUserUsername(@PathVariable String username) {
//        return bankAccountService.findByBankUserUsername(username);
//    }
//
//    @GetMapping("/findByFullname/{fullname}")
//    public List<BankAccount> findByBankUserFullname(@PathVariable String fullname) {
//        return bankAccountService.findByBankUserFullname(fullname);
//    }
//
//    @GetMapping("/findById/{id}")
//    public BankAccount findById(@PathVariable Long id) {
//        return bankAccountService.findById(id);
//    }
//
//    //---------------------------------------------------------------------------//
//
//    @PutMapping("/update")
//    public BankAccount update(@RequestBody BankAccount bankAccount) {
//        return bankAccountService.save(bankAccount);
//    }
//
//    //---------------------------------------------------------------------------//
//
//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable Long id) {
//        bankAccountService.deleteById(id);
//    }
//
//
//    //---------------------------------------------------------------------------//


}




