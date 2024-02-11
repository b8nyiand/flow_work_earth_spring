package hu.flowacademy.jobs;

import hu.flowacademy.jobs.model.Job;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.JobRepository;
import hu.flowacademy.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JobsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobsApplication.class, args);
    }
    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserRepository userRepository;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            if (userRepository.findAll().isEmpty()) {
                User user = new User("Tamás", "Kovács Tamás", LocalDate.now());
                User user1 = new User("Tamás", "Kovács Tamás", LocalDate.now());
                userRepository.save(user);
                userRepository.save(user1);

                Job job = new Job("Telekom", 200000, "Costumer support", LocalDate.now(), user);
                Job job1 = new Job("Emap", 300000, "Junior Dev",  LocalDate.now(), user);
                Job job2 = new Job("Telekom", 1000000, "Senior dev",  LocalDate.now(), user1);
                Job job3 = new Job("Wolt", 250000, "Delivery",  LocalDate.now(), user1);

                jobRepository.save(job);
                jobRepository.save(job1);
                jobRepository.save(job2);
                jobRepository.save(job3);
            }
        };

    }
}

