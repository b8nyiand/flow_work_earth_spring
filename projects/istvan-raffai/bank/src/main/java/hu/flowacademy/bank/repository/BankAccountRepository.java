package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    
    



}
