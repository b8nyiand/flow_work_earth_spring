package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.repository.AccountOwnerRepository;
import hu.flowacademy.bank.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountStatService {


    @Autowired
    public BankAccountRepository bankAccountRepository;

    @Autowired
    public AccountOwnerRepository accountOwnerRepository;

    public List<BankAccount> above3000EUR(){
       return bankAccountRepository.findAll()
               .stream()
               .filter(x-> x.getBalance() > 3000 && x.getCurrency().equals("EUR"))
               .collect(Collectors.toList());
    }

    public List<BankAccount> below3000HUF(){
        return bankAccountRepository.findAll()
                .stream()
                .filter(x->x.getBalance()<3000 && x.getCurrency().equals("HUF"))
                .collect(Collectors.toList());
    }
    public List<BankAccount> currencyEUR(){
        return bankAccountRepository.findAll()
                .stream().
                filter(x->x.getCurrency().equals("EUR")).
                collect(Collectors.toList());
    }

    public List<BankAccount> currencyList(String currency){
        return bankAccountRepository.findAll()
                .stream().
                filter(x->x.getCurrency().equals(currency)).
                collect(Collectors.toList());
    }

    public List<BankAccount> biggerBalance(Integer balance, String currency){
        return bankAccountRepository.findAll()
                .stream()
                .filter(x->x.getBalance()>balance && x.getCurrency().equals(currency))
                .collect(Collectors.toList());
    }

}
