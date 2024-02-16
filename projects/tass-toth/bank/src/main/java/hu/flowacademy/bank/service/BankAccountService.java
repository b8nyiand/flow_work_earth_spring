package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.Customer;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount createBankAccount(String username, BankAccount bankAccount) {
        Customer customer = (Customer) customerRepository.findByUsername(username);
        if (customer != null) {
            bankAccount.setCustomer(customer);
            return bankAccountRepository.save(bankAccount);
        } else {
            throw new RuntimeException("Hiba! A user nem található: " + username);

        }
    }


    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public void deleteBankAccount(Long id) {
        bankAccountRepository.deleteById(id);
    }

    public List<BankAccount> getBankAccountsByUserName(String userName) {
        return bankAccountRepository.findByUserName(userName);
    }

    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    public List<BankAccount> getBankAccountsBalanceGreaterThanAmountAndCurrency(Integer amount, String currency) {
        return bankAccountRepository.findByBalanceGreaterThanAndCurrency(amount, currency);
    }

    public List<BankAccount> getBankAccountsBalanceLessThanAmountAndCurrency(Integer amount, String currency) {
        return bankAccountRepository.findByBalanceLessThanAndCurrency(amount, currency);
    }

    public List<BankAccount> getBankAccountsByCurrency(String currency) {
        return bankAccountRepository.findByCurrency(currency);
    }

    public List<BankAccount> getBankAccountsBalanceGreaterThanAmount(Integer amount) {
        return bankAccountRepository.findByBalanceGreaterThan(amount);
    }


}
