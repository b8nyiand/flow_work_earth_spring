package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankUserRepository extends JpaRepository<BankUser, String> {

    BankUser findByUsername(String username);

    List<BankUser> findByFullname(String fullname);

    @Modifying
    @Query("DELETE FROM BankUser u WHERE u.username= :userName")
    void deleteByUsername(@Param("userName") String username);



}
