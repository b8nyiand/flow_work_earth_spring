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
            "((:fullname IS NULL OR :fullname = '' ) OR u.fullname = :fullname) AND " +
            "((:username IS NULL OR :username = '' ) OR u.username = :username) AND " +
            "((:email IS NULL OR :email = '' ) OR u.email = :email) AND " +
            "((:address IS NULL OR :address = '') OR u.address = :address)")
    List<BankUser> findByOptionalFUEA(@Param("fullname") String fullname,
                                      @Param("username") String username,
                                      @Param("email") String email,
                                      @Param("address") String address);

//    private LocalDate creationDate;
//    private Boolean isAdmin;

}
