package hu.flowacademy.bank.controller;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.service.AccountStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stat")
public class AccountStatController {

    @Autowired
    public AccountStatService accountStatService;

    @GetMapping("/above3000eur")
    public List<BankAccount> above3000EUR(){
        return accountStatService.above3000EUR();
    }

    @GetMapping("/below3000huf")
    public List<BankAccount> below3000HUF(){
        return accountStatService.below3000HUF();
    }
    @GetMapping("/eur")
    public List<BankAccount> currencyEUR(){
        return accountStatService.currencyEUR();
    }
    @GetMapping("/currency/{currency}")
    public List<BankAccount> currencyList(@PathVariable String currency){
        return accountStatService.currencyList(currency);
    }

    @GetMapping("/balanceAndCurrency/{balance}/{currency}")
    public List<BankAccount> biggerBalance(@PathVariable Integer balance, @PathVariable String currency){
        return accountStatService.biggerBalance(balance, currency);
    }

}
