package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.User;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private UserRepository userRepository;

    public BankAccount createBankAccountForUser(String userName, BankAccount bankAccount) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            bankAccount.setUser(user);
            return bankAccountRepository.save(bankAccount);
        } else {
            throw new RuntimeException("cannot find user: " + userName);
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






