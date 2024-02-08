package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankUserRepository extends JpaRepository <BankUser, String> {

}
