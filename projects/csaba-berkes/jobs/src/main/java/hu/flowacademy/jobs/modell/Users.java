package hu.flowacademy.jobs.modell;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Users {
    @Id
    private String username;
    private String fullname;
    private LocalDate creationDate;
    @OneToMany(mappedBy = "users")
    private List<Job> jobList;

    public Users() {
    }

    public Users(String username, String fullname, LocalDate creationDate) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
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

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", creationDate=" + creationDate +
                ", jobList=" + jobList +
                '}';
    }
}
