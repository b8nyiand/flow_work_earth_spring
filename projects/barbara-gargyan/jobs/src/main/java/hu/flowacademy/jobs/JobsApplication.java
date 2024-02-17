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
    public CommandLineRunner runner() {
        return args -> {
            if (userRepository.findAll().isEmpty()) {
                User user = new User("kissA", "Kiss Antónia", LocalDate.now());
                User user1 = new User("molnar1", "Molnar András", LocalDate.now());
                User user2 = new User("molnarka", "Molnar Ágota", LocalDate.now());
                User user3 = new User("springes", "Spring Sándor", LocalDate.now());
                User user4 = new User("user", "User Ubul", LocalDate.now());

                userRepository.save(user);
                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);


                Jobs job = new Jobs("séf", 1_000_000, "konyhai munka", "kissA", LocalDate.now(), user);
                Jobs job1 = new Jobs("nővér", 600_000, "korházi munka", "molnar1", LocalDate.now(), user1);
                Jobs job2 = new Jobs("takarító", 300_000, "intézmények takarítása", "molnarka", LocalDate.now(), user2);
                Jobs job3 = new Jobs("spring", 1_100_000, "spring developer", "springes", LocalDate.now(), user3);
                Jobs job4 = new Jobs("eladó", 480_000, "bolti eladó", "user", LocalDate.now(), user4);

                jobsRepository.save(job);
                jobsRepository.save(job1);
                jobsRepository.save(job2);
                jobsRepository.save(job3);
                jobsRepository.save(job4);


            }
        };
    }


}

