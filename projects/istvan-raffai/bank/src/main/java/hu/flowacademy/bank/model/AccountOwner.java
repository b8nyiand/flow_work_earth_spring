package hu.flowacademy.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class AccountOwner {


    @Id
    private String userName;
    private String fullName;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "accountOwner")
    private List<BankAccount> accounts;

    public AccountOwner() {
    }

    public AccountOwner(String userName, String fullName, LocalDate creationDate) {
        this.userName = userName;
        this.fullName = fullName;
        this.creationDate = creationDate;

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

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "AccountOwner{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", creationDate=" + creationDate +
                ", accounts=" + accounts +
                '}';
    }
}
