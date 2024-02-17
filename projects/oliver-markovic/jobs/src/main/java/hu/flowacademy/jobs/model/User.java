package hu.flowacademy.jobs.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String username;
    private String fullName;
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @OneToMany(mappedBy = "user")
    private List<Job> job;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDate.now();
    }

    public User(String userName, String fullName, LocalDate creationDate) {
        this.username = userName;
        this.fullName = fullName;
        this.creationDate = creationDate;
    }

    public User() {
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


}
