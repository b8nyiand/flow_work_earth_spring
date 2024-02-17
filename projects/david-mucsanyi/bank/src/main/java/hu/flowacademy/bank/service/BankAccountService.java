package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.CurrencyType;
import hu.flowacademy.bank.repository.BankAccountRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {


    @Autowired
    private BankAccountRepositry bankAccountRepositry;

    public BankAccountService(BankAccountRepositry bankAccountRepositry) {
        this.bankAccountRepositry = bankAccountRepositry;
    }

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepositry.save(bankAccount);
    }

    public List<BankAccount> findBankAccountById(Long id) {
        return bankAccountRepositry.findBankAccountById(id);
    }

    public List<BankAccount> findAllBankAccount() {
        return bankAccountRepositry.findAll();
    }

    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return bankAccountRepositry.save(bankAccount);
    }

    public void deleteById(Long id) {
        bankAccountRepositry.deleteById(id);
    }

    public List<BankAccount> findBankAccountsByName() {
        return bankAccountRepositry.findAll();
    }

    public List<BankAccount> getAccountsByCurrency(CurrencyType HUF) {
        return bankAccountRepositry.getAccountsByCurrency(CurrencyType.valueOf(String.valueOf(HUF)));

    }

    public List<BankAccount> getAccountsBalanceGreaterThan(int balance) {
        return bankAccountRepositry.findByBalanceGreaterThanAndCurrency(balance);
    }

    public List<BankAccount> getAccountsBalanceLessThan(int balance, String currency) {
        return bankAccountRepositry.findByBalanceLessThanAndCurrency(balance, currency);
    }


}
