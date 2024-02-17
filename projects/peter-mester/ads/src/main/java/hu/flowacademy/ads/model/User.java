package hu.flowacademy.ads.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="t_user")
public class User {

    @Id
    private String userName;
    private String fullName;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "user")
    private List<Ad> ads;

    public User(String userName, String fullName, LocalDate creationDate) {
        this.userName = userName;
        this.fullName = fullName;
        this.creationDate = creationDate;
    }

    public User() {
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

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", creationDate=" + creationDate +
                ", ads=" + ads +
                '}';
    }
}
