package hu.flowacademy.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private Integer balance;
    private String currency;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    @JsonIgnore
    private Customer customer;
    @Column(nullable = false)
    private LocalDate creationDate;


    public BankAccount() {
    }

    public BankAccount(String accountNumber, Integer balance, String currency, Customer customer,LocalDate creationDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.customer = customer;
        this.creationDate = creationDate;
    }

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDate.now();
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}