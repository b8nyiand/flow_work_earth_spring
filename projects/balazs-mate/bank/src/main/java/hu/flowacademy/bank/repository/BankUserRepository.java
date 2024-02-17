package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BankUserRepository extends JpaRepository<BankUser, String> {


    BankUser findByUsername(String username);

    List<BankUser> findByFullname(String fullname);

    @Modifying
    @Query("DELETE FROM BankUser u WHERE u.username= :userName")
    void deleteByUsername(@Param("userName") String username);


    //Queries with multiple optional parameters
    @Query("SELECT u FROM BankUser u WHERE " +
            "((:fullname IS NULL OR :fullname = '' ) OR LOWER(u.fullname) LIKE CONCAT('%', LOWER(:fullname), '%')) AND " +
            "((:username IS NULL OR :username = '' ) OR u.username = :username) AND " +
            "((:address IS NULL OR :address = '') OR LOWER(u.address) LIKE CONCAT('%', LOWER(:address), '%'))")
    List<BankUser> findByOptionalFUA(@Param("fullname") String fullname,
                                     @Param("username") String username,
                                     @Param("address") String address);


}
