package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findByUsername(String username);

    List<BankAccount> findByCurrency(String currency);

    List<BankAccount> findByBalanceGreaterThan(Integer balance);

    List<BankAccount> findByBalanceLessThanAndCurrency(Integer balance, String currency);

    List<BankAccount> findByBalanceGreaterThanAndCurrency(Integer balance, String currency);
}