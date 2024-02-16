package hu.flowacademy.jobs;

import hu.flowacademy.jobs.model.Jobs;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.JobsRepository;
import hu.flowacademy.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JobsApplication {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobsRepository jobsRepository;

    public static void main(String[] args) {
        SpringApplication.run(JobsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {                                 // tesztadatok az adatbázishoz
        return args -> {
            if (userRepository.findAll().isEmpty()) {                   // ha nincs user elem az adatbázisban -> CSAK AKKOR hajtódjon végre! (1x fut le, feltölti adatokkal az adatázis)

                User user = new User("kissA", "Kiss Antónia", LocalDate.now());
                User user1 = new User("molnar1", "Molnár András", LocalDate.now());
                User user2 = new User("molnárka", "Molnár Ágota", LocalDate.now());
                User user3 = new User("springes", "Spring Sándor", LocalDate.now());

                userRepository.save(user);
                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);


                Jobs job = new Jobs("Séf", 900_000, "konyhai munka", "kissA", LocalDate.now(), user);
                Jobs job1 = new Jobs("Nővér", 600_000, "korházi munka", "molnar1", LocalDate.now(), user1);
                Jobs job2 = new Jobs("Takarító", 300_000, "intézmények takarítása", "molnarka", LocalDate.now(), user2);
                Jobs job3 = new Jobs("Spring", 1_000_000, "Spring dev.", "springes", LocalDate.now(), user3);

                jobsRepository.save(job);
                jobsRepository.save(job1);
                jobsRepository.save(job2);
                jobsRepository.save(job3);


            }
        };
    }


}

