package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepositry extends JpaRepository<BankAccount, Long> {



    public List<BankAccount> findBankAccountById(Long id);

    public List<BankAccount> getAccountsByCurrency(CurrencyType currencyType);

    public List<BankAccount> findByBalanceGreaterThanAndCurrency(int balance);

    List<BankAccount> findByBalanceLessThanAndCurrency(int balance, String currency);

}
