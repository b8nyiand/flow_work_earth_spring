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
    private String currency;
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "username")
    private BankUser BankUser;

    public BankAccount(String accountNumber, Integer balance, String currency, hu.flowacademy.bank.model.BankUser bankUser) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        BankUser = bankUser;
    }

    public BankAccount(String accountNumber, Integer balance, String currency) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
    }
}
