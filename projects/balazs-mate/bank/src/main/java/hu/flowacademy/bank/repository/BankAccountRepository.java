package hu.flowacademy.bank.repository;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    List<BankAccount> findByBankUserUsername(String username);

    List<BankAccount> findByBankUserFullname(String fullname);

    //StatController's methods
    //---------------------------------------------------------------------------//


    BankAccount findByAccountNumber(String accountNumber);

    List<BankAccount> findByCurrency(Currency currency);

    @Query("Select a from BankAccount a where currency=:currency and balance>= :lowerLimit")
    List<BankAccount> findByCurrencyAndBalanceLowerLimit(@Param("currency") Currency currency, @Param("lowerLimit") Integer lowerLimit);

    @Query("Select a from BankAccount a where currency=:currency and balance <= :upperLimit")
    List<BankAccount> findByCurrencyAndBalanceUpperLimit(@Param("currency") Currency currency, @Param("upperLimit") Integer upperLimit);

    @Query("Select a from BankAccount a where currency=:currency and balance>= :lowerLimit and balance <= :upperLimit")
    List<BankAccount> findByCurrencyAndBalanceRange(@Param("currency") Currency currency, @Param("lowerLimit") Integer lowerLimit, @Param("upperLimit") Integer upperLimit);

    //Queries with multiple optional parameters
    @Query("SELECT ba FROM BankAccount ba WHERE " +
            "((:lowerLimit IS NULL OR :lowerLimit = 0 ) OR ba.balance >= :lowerLimit) AND " +
            "((:upperLimit IS NULL OR :upperLimit = 0 ) OR ba.balance <= :upperLimit) AND " +
            "((:currency IS NULL) OR ba.currency = :currency) AND " +
            "((cast(:startDate as date) IS NULL) OR ba.creationDate >= :startDate) AND " +
            "((cast(:endDate as date) IS NULL)OR ba.creationDate <= :endDate)")
    List<BankAccount> findByMultipleConditions(@Param("lowerLimit") Integer lowerLimit,
                                               @Param("upperLimit") Integer upperLimit,
                                               @Param("currency") Currency currency,
                                               @Param("startDate") LocalDate startDate,
                                               @Param("endDate") LocalDate endDate);


}
