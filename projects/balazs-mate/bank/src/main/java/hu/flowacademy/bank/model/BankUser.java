package hu.flowacademy.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BankUser {

    @Id
    @Column(unique = true)
    private String username;
    private String fullname;
    private LocalDate creationDate;
    private String email;
    private String password;
    @Setter(AccessLevel.NONE)
    private Boolean isAdmin;
    private String address;

    @Transient
    private String country;
    @Transient
    private String city;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "bankUser")
    private List<BankAccount> accounts;

    public BankUser(String username, String fullname, LocalDate creationDate, Boolean isAdmin, String address) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
        this.isAdmin = isAdmin;
        this.address = address;
    }

    public BankUser(String username, String fullname, LocalDate creationDate,  String address) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
        this.address = address;
    }

    public BankUser(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }

//    public void setAddress(String address) {
//        if (address == null || address.isEmpty()) {
//            this.address = this.country + ", " + this.city;
//        } else {
//            this.address = address;
//        }
//    }

}
