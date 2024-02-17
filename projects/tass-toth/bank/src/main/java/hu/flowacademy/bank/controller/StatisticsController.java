package hu.flowacademy.bank.controller;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/balance-greater-than-3000-EUR")
    public List<BankAccount> getBankAccountsBalanceGreaterThan3000EUR() {
        return bankAccountService.getBankAccountsBalanceGreaterThanAmountAndCurrency(3000, "EUR");
    }

    @GetMapping("/balance-less-than-3000-HUF")
    public List<BankAccount> getBankAccountsBalanceLessThan3000HUF() {
        return bankAccountService.getBankAccountsBalanceLessThanAmountAndCurrency(3000, "HUF");
    }

    @GetMapping("/currency-EUR")
    public List<BankAccount> getBankAccountsByCurrencyEUR() {
        return bankAccountService.getBankAccountsByCurrency("EUR");
    }

    @GetMapping("/currency/{currency}")
    public List<BankAccount> getBankAccountsByCurrency(@PathVariable String currency) {
        return bankAccountService.getBankAccountsByCurrency(currency);
    }

    @GetMapping("/balance-greater-than/{amount}")
    public List<BankAccount> getBankAccountsBalanceGreaterThan(@PathVariable Integer amount) {
        return bankAccountService.getBankAccountsBalanceGreaterThanAmount(amount);
    }
}