package hu.flowacademy.jobs;

import hu.flowacademy.jobs.modell.Job;
import hu.flowacademy.jobs.modell.Users;
import hu.flowacademy.jobs.repository.JobRepository;
import hu.flowacademy.jobs.repository.UsersRepository;
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
	private UsersRepository usersRepository;
	@Autowired
	private JobRepository jobRepository;
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			if (usersRepository.findAll().isEmpty()) {
				Users user1 = new Users("bcs89", "Berkes Csaba", LocalDate.now());
				usersRepository.save(user1);

				Job job1 = new Job("Programozo", 500000, "Leirasss", user1, LocalDate.now());
				Job job2 = new Job("Asztalos", 100000, "Leirasss222", user1, LocalDate.now());
				jobRepository.save(job1);
				jobRepository.save(job2);
			}
		};

	}

}
