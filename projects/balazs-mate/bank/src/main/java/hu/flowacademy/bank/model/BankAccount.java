package hu.flowacademy.bank.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class BankAccount {

    @Id
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


    public BankAccount(String accountNumber, Integer balance, Currency currency, LocalDate creationDate, hu.flowacademy.bank.model.BankUser bankUser) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.creationDate = creationDate;
        this.bankUser = bankUser;
    }

    public BankAccount(String accountNumber, Integer balance, Currency currency, hu.flowacademy.bank.model.BankUser bankUser) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.bankUser = bankUser;
    }

    public BankAccount(String accountNumber, Integer balance, Currency currency) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
    }

}
