package hu.flowacademy.bank.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {


    @Id
    private String username;
    private String fullname;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccount;


    public User(String username, String fullname, LocalDate creationDate) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
