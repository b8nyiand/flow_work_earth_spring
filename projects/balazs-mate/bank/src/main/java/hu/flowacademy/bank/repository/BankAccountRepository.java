package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    List<BankAccount> findByBankUserUsername(String username);

    List<BankAccount> findByBankUserFullname(String fullname);

    //StatController's methods
    //---------------------------------------------------------------------------//


    List<BankAccount> findByCurrency(Currency currency);

    @Query("Select a from BankAccount a where currency=:currency and balance>= :lowerLimit")
    List<BankAccount> findByCurrencyAndBalanceLowerLimit(@Param("currency") Currency currency, @Param("lowerLimit") Integer lowerLimit);

    @Query("Select a from BankAccount a where currency=:currency and balance <= :upperLimit")
    List<BankAccount> findByCurrencyAndBalanceUpperLimit(@Param("currency") Currency currency, @Param("upperLimit") Integer upperLimit);

    @Query("Select a from BankAccount a where currency=:currency and balance>= :lowerLimit and balance <= :upperLimit")
    List<BankAccount> findByCurrencyAndBalanceRange(@Param("currency") Currency currency, @Param("lowerLimit") Integer lowerLimit, @Param("upperLimit") Integer upperLimit);


    //Queries with multiple optional parameters
/*
 @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private Integer balance;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "username")
    private BankUser bankUser;
 */


}
