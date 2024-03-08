package hu.flowacademy.jobs.modell;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Users {
    @Id
    private String username;
    private String fullname;
    private LocalDate creationDate;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "users")
    private List<Job> jobList;

    public Users(String username, String fullname, LocalDate creationDate) {
        this.username = username;
        this.fullname = fullname;
        this.creationDate = creationDate;
    }

}
