package hu.flowacademy.bank.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private int balance;
    @Enumerated(EnumType.ORDINAL)
    private CurrencyType currency;
    @Column(name = "username", insertable = false, updatable = false)
    private String username;
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    @JsonIgnore
    private User user;

    public BankAccount(String accountNumber, CurrencyType currency, String username, LocalDate creationDate, User user) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.username = username;
        this.creationDate = creationDate;
        this.user = user;
    }

    public BankAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", currencey='" + currency + '\'' +
                ", username='" + username + '\'' +
                ", creationDate=" + creationDate +
                ", user=" + user +
                '}';
    }
}
