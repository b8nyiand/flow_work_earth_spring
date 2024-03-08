package hu.flowacademy.jobs.modell;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int salary;
    private String description;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "username", nullable = false)
    @JsonIgnore
    private Users users;
    private LocalDate creationDate;

    public Job(String title, int salary, String description, Users users, LocalDate creationDate) {
        this.title = title;
        this.salary = salary;
        this.description = description;
        this.users = users;
        this.creationDate = creationDate;
    }

}
