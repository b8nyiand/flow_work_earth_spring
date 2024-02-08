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
    @JoinColumn(name = "username", nullable = false)
    private BankUser BankUser;

    public BankAccount(Long id, String accountNumber, Integer balance, String currency, hu.flowacademy.bank.model.BankUser bankUser) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        BankUser = bankUser;
    }
}
