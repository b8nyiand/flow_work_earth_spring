package hu.flowacademy.bank.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

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


    public BankAccount(Integer balance, Currency currency, LocalDate creationDate, hu.flowacademy.bank.model.BankUser bankUser) {
        this.balance = balance;
        this.currency = currency;
        this.creationDate = creationDate;
        this.bankUser = bankUser;
    }

    public BankAccount(Integer balance, Currency currency, hu.flowacademy.bank.model.BankUser bankUser) {
        this.balance = balance;
        this.currency = currency;
        this.bankUser = bankUser;
    }

    public BankAccount(Integer balance, Currency currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public void setRandomAccountNumber() {
        int lowerLimit = 0;
        int upperlimit = 1000000;
        int tag1 = ThreadLocalRandom.current().nextInt(lowerLimit, upperlimit);
        int tag2 = ThreadLocalRandom.current().nextInt(lowerLimit, upperlimit);
        StringBuffer sb = new StringBuffer();
        this.accountNumber = sb.append("BA").append("-").append(tag1).append("-").append(tag2).toString();
    }
}
