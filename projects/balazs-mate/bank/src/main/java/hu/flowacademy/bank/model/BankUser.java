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

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "bankUser")
    private List<BankAccount> accounts;

    public BankUser(String username, String fullname, LocalDate creationDate, Boolean isAdmin) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
        this.isAdmin = isAdmin;
    }

    public BankUser(String username, String fullname, LocalDate creationDate) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
    }

    public BankUser(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }
}
