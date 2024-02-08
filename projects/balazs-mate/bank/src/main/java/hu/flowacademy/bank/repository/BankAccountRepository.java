package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {


}
