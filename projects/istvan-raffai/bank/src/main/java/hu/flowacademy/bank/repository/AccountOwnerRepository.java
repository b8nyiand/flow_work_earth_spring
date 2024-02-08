package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.AccountOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOwnerRepository extends JpaRepository<AccountOwner, String> {
}
