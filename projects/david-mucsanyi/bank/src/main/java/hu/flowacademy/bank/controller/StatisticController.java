package hu.flowacademy.bank.controller;


import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.CurrencyType;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stats")
@RestController
public class StatisticController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/findbyId/{id}")
    public Class<BankAccountService> findbyId(@PathVariable Long id) {
        return BankAccountService.class;
    }

    @GetMapping("/greater_than")
    public ResponseEntity<List<BankAccount>> getAccountsBalanceGreaterThan3000EUR() {
        List<BankAccount> accounts = bankAccountService.getAccountsBalanceGreaterThan(3000);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/less_than")
    public ResponseEntity<List<BankAccount>> getAccountsBalanceLessThan3000HUF() {
        List<BankAccount> accounts = bankAccountService.getAccountsBalanceLessThan(3000, "HUF");
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/currency_eur")
    public ResponseEntity<List<BankAccount>> getAccountsByCurrencyEUR() {
        List<BankAccount> accounts = bankAccountService.getAccountsByCurrency(CurrencyType.valueOf("EUR"));
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/by_currency")
    public ResponseEntity<List<BankAccount>> getAccountsByCurrency(@RequestParam String currency) {
        List<BankAccount> accounts = bankAccountService.getAccountsByCurrency(CurrencyType.valueOf(currency));
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/balance_higher")
    public ResponseEntity<List<BankAccount>> getAccountsBalanceHigherThan(@RequestParam int balance) {
        List<BankAccount> accounts = bankAccountService.getAccountsBalanceGreaterThan(balance);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

}
