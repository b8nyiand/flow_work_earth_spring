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

    public BankAccount(BankUser bankUser) {
        this.bankUser = bankUser;
    }

    public void setRandomAccountNumber() {
        int lowerLimit = 0;
        int upperlimit = 1000000;
        int tag1 = ThreadLocalRandom.current().nextInt(lowerLimit, upperlimit);
        int tag2 = ThreadLocalRandom.current().nextInt(lowerLimit, upperlimit);
        StringBuffer sb = new StringBuffer();
        this.accountNumber = sb.append("BA").append("-").append(tag1).append("-").append(tag2).toString();
    }

    public BankAccount setRandomBalance() {
        int limitLower = 0;
        int limitUpper = 100;
        this.balance = ThreadLocalRandom.current().nextInt(limitLower, limitUpper) * 1000;
        return this;
    }

    public BankAccount setRandomCurrency() {
        this.currency = Currency.values()[ThreadLocalRandom.current().nextInt(0, Currency.values().length)];
        return this;
    }

    /**
     * BankAccount have to have a BankUser initially
     *
     * @return the BankAccount with a creationDate which is after the UserAccount's creationDate
     */
    public BankAccount setRandomCreationDate() {
        long minDay = this.bankUser.getCreationDate().toEpochDay();
        long maxDay = LocalDate.now().toEpochDay() + 1;
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        this.creationDate = LocalDate.ofEpochDay(randomDay);
        return this;
    }

}
