package hu.flowacademy.jobs.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String fullName;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "user")
    private List<Jobs> jobsList;

    public User() {
    }

    public User(String userName, String fullName, LocalDate creationDate) {
        this.userName = userName;
        this.fullName = fullName;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public List<Jobs> getJobsList() {
        return jobsList;
    }
}
