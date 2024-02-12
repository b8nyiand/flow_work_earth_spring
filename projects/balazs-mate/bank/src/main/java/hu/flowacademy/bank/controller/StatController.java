package hu.flowacademy.bank.controller;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank/stat")
public class StatController {


    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("/{currency}")
    List<BankAccount> findByCurrency(@PathVariable String currency) {
        return bankAccountService.findByCurrency(currency);
    }

    @GetMapping("/less than 3000 HUF")
    public List<BankAccount> findByBalanceLowerThan3000AndCurrencyIsHUF() {
        return bankAccountService.findByCurrencyAndBalanceUpperLimit("HUF", 3000);
    }

    @GetMapping("/{currency}/l/{lowerLimit}")
    public List<BankAccount> findByCurrencyAndBalanceLowerLimit(@PathVariable String currency, @PathVariable Integer lowerLimit) {
        return bankAccountService.findByCurrencyAndBalanceLowerLimit(currency, lowerLimit);
    }

    @GetMapping("/more than 3000 EURO")
    public List<BankAccount> findByBalanceGreaterThan3000AndCurrencyIsEUR() {
        return bankAccountService.findByCurrencyAndBalanceLowerLimit("EUR", 3000);
    }

    @GetMapping("/{currency}/u/{upperLimit}")
    public List<BankAccount> findByCurrencyAndBalanceUpperLimit(@PathVariable String currency, @PathVariable Integer upperLimit) {
        return bankAccountService.findByCurrencyAndBalanceUpperLimit(currency, upperLimit);
    }

    @GetMapping("/{currency}/{lowerLimit}/{upperLimit}")
    public List<BankAccount> findByCurrencyAndBalanceRange(@PathVariable String currency, @PathVariable Integer lowerLimit, @PathVariable Integer upperLimit) {
        return bankAccountService.findByCurrencyAndBalanceRange(currency, lowerLimit, upperLimit);
    }

}
