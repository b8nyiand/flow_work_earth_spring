package hu.flowacademy.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;


import java.time.LocalDate;

@Entity
public class User {
    @Id
    private String username;
    private String fullname;
    private LocalDate creationDate;

    public User(String user1, String userOne, LocalDate now) {
    }

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDate.now();
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
}