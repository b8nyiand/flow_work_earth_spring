package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    //---------------------------------------------------------------------------//

    public BankAccount save(BankAccount bankAccount) {
        if (bankAccount.getCreationDate() == null) {
            bankAccount.setCreationDate(LocalDate.now());
        }
        if (bankAccount.getAccountNumber() == null) {
            bankAccount.setRandomAccountNumber();
        }
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

    public BankAccount findByAccountNumber(String accountNumber) {
        return bankAccountRepository.findByAccountNumber(accountNumber);
    }

    //Stat controller's methods

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

    public List<BankAccount> findByMultipleConditions(Integer limit1,
                                                      Integer limit2,
                                                      String currencyStr,
                                                      String startDateStr,
                                                      String endDateStr) {

        //Testing
        System.out.println(LocalDate.now());
        System.out.println(limit1 + " " + limit2 + " " + currencyStr + " " + startDateStr + " " + endDateStr);
        Integer lowerLimit, upperLimit;

        if (limit1 != null && limit2 != null) {
            lowerLimit = Math.min(limit1, limit2);
            upperLimit = Math.max(limit1, limit2);
        } else if (limit1 == limit2) {
            lowerLimit = 0;
            upperLimit = 0;
        } else {
            lowerLimit = limit1;
            upperLimit = limit2;
        }

        Currency currency = (currencyStr == null || currencyStr.equals("")) ? null : Currency.valueOf(currencyStr.toUpperCase());
        LocalDate startDate = (startDateStr == null || startDateStr.equals("")) ? null : LocalDate.parse(startDateStr);
        LocalDate endDate = (endDateStr == null || endDateStr.equals("")) ? null : LocalDate.parse(endDateStr);

        //Testing
        System.out.println(startDate);
        System.out.println(endDate);


        return bankAccountRepository.findByMultipleConditions(lowerLimit, upperLimit, currency, startDate, endDate);
    }

    //---------------------------------------------------------------------------//

    public void deleteById(Long id) {
        bankAccountRepository.deleteById(id);
    }

    //---------------------------------------------------------------------------//


}
