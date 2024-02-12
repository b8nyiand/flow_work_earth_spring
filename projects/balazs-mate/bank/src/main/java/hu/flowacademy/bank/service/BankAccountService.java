package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    //---------------------------------------------------------------------------//

    public BankAccount save(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    //---------------------------------------------------------------------------//

    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }


    public List<BankAccount> findByBankUserUsername(String username) {
        return bankAccountRepository.findByBankUserUsername(username);
    }

    public List<BankAccount> findByBankUserFullname(String fullname) {
        return bankAccountRepository.findByBankUserFullname(fullname);
    }

    public BankAccount findById(Long id) {
        return bankAccountRepository.findById(id).orElseThrow();
    }

    //Stat controller's methods

    //IllegalArgumentException - handle in case of tipos!!!
    public List<BankAccount> findByCurrency(String currencyStr) {
        Currency currency = Currency.valueOf(currencyStr.toUpperCase());
        return bankAccountRepository.findByCurrency(currency);
    }

    public List<BankAccount> findByCurrencyAndBalanceLowerLimit(String currencyStr, Integer lowerLimit) {
        Currency currency = Currency.valueOf(currencyStr.toUpperCase());
        return bankAccountRepository.findByCurrencyAndBalanceLowerLimit(currency, lowerLimit);
    }

    public List<BankAccount> findByCurrencyAndBalanceUpperLimit(String currencyStr, Integer upperLimit) {
        Currency currency = Currency.valueOf(currencyStr.toUpperCase());
        return bankAccountRepository.findByCurrencyAndBalanceUpperLimit(currency, upperLimit);
    }

    public List<BankAccount> findByCurrencyAndBalanceRange(String currencyStr, Integer lowerLimit, Integer upperLimit) {
        Currency currency = Currency.valueOf(currencyStr.toUpperCase());
        return bankAccountRepository.findByCurrencyAndBalanceRange(currency, lowerLimit, upperLimit);
    }


    //---------------------------------------------------------------------------//

    //---------------------------------------------------------------------------//

    public void deleteById(Long id) {
        bankAccountRepository.deleteById(id);
    }

    //---------------------------------------------------------------------------//


}
