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
@ToString
@Entity
public class BankUser {

    @Id
    @Column(unique = true)
    private String username;
    private String fullname;
    private LocalDate creationDate;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(mappedBy = "bankUser")
    private List<BankAccount> accounts;


    public BankUser(String username, String fullname, LocalDate creationDate) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
    }

    public BankUser(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = LocalDate.now();
    }
}
