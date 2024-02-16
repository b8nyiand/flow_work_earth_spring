package hu.flowacademy.bank.webcontroller;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.service.BankAccountService;
import hu.flowacademy.bank.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/bank/account/")

public class BankAccountWebController {


    @Autowired
    BankAccountService bankAccountService;
    @Autowired
    BankUserService bankUserService;


    @GetMapping("/new/{username}")
    public String showForm(Model model, @PathVariable String username) {
        model.addAttribute("currencies", Currency.values());
        model.addAttribute("username", username);
        return "register_account";
    }

    @PostMapping("/new")
    public String save(@RequestParam(required = true, name = "username") String username,
                       @RequestParam(required = true, name = "currencyStr") String currencyStr,
                       @RequestParam(required = false, name = "balance") Integer balance,
                       Model model) {

        balance = balance == null ? 0 : balance;
        BankUser bankUser = bankUserService.findByUsername(username);
        BankAccount bankAccount = new BankAccount(balance, Currency.valueOf(currencyStr), bankUser);
        bankAccountService.save(bankAccount);
        model.addAttribute("account", bankAccount);
        return "account_info";
    }

    @GetMapping("/findByAccountnumber/{accountNumber}")
    public String findByAccountNumber(Model model, @PathVariable String accountNumber) {
        model.addAttribute("account", bankAccountService.findByAccountNumber(accountNumber));
        return "account_info";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("bankaccounts", bankAccountService.findAll());
        return "accounts";
    }

    @GetMapping("/search")
    public String findByOptionalFUA() {
        return "accounts";
    }

    @PostMapping("/search")
    public String findByMultipleConditions(Model model,
                                           @RequestParam(required = false, name = "limit1") Integer limit1,
                                           @RequestParam(required = false, name = "limit2") Integer limit2,
                                           @RequestParam(required = false, name = "currency") String currencyStr,
                                           @RequestParam(required = false, name = "creationStartDate") String startDateStr,
                                           @RequestParam(required = false, name = "creationEndDate") String endDateStr) {

        model.addAttribute("bankaccounts", bankAccountService.findByMultipleConditions(limit1, limit2, currencyStr, startDateStr, endDateStr));
        return "accounts";
    }

}




