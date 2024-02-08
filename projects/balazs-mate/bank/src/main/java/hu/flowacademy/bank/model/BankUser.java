package hu.flowacademy.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class BankUser {

    @Id
    private String username;
    private String fullname;
    private LocalDate creationDate;

    @JsonIgnore
    @OneToMany(mappedBy = "username")
    private List<BankAccount> accounts;

    public BankUser(String username, String fullname, List<BankAccount> accounts) {
        this.username = username;
        this.fullname = fullname;
        this.accounts = accounts;
    }
}
