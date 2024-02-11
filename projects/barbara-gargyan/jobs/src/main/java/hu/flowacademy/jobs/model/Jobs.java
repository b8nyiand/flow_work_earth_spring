package hu.flowacademy.jobs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Integer salary;
    private String description;

    private String userName; // foreign key
    private LocalDate creationDate;


    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false) // ezen keresztül kapcsolódik
    @JsonIgnore
    private User user;

    public Jobs() {
    }

    public Jobs(String title, Integer salary, String description, String userName, LocalDate creationDate, User user) {
        this.title = title;
        this.salary = salary;
        this.description = description;
        this.userName = userName;
        this.creationDate = creationDate;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
