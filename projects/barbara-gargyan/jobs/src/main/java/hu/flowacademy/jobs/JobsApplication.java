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

    public static void main(String[] args) {SpringApplication.run(JobsApplication.class, args);}

    @Bean
    public CommandLineRunner runner() {                                 // tesztadatok az adatbázishoz
        return args -> {
            if (userRepository.findAll().isEmpty()) {                   // ha nincs user elem az adatbázisban -> CSAK AKKOR hajtódjon végre! (1x fut le, feltölti adatokkal az adatázis)

               User user= new User("kissA", "Kiss Antónia", LocalDate.now());
                User user1= new User("molnar1", "Molnár András",LocalDate.now());
                userRepository.save(user);


                Jobs job = new Jobs("séf", 500_000, "konyhai munka", "molnar1",LocalDate.now(), user1);
                Jobs job1 = new Jobs("nővér", 600_000, "korházi munka", "molnar1", LocalDate.now(), user);

               jobsRepository.save(job);
               jobsRepository.save(job1);


            }
        };
    }


}

