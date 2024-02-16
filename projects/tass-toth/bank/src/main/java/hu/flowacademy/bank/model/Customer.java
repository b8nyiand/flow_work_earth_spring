package hu.flowacademy.bank.model;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private String username;
    private String fullname;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccountList;

    @PrePersist
    public void prePersist() {
        creationDate = LocalDate.from(LocalDateTime.now());
    }

    public Customer() {
    }


    public Customer(String username, String fullname, LocalDate creationDate) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

}