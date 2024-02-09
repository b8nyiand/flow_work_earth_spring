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
				Users user2 = new Users("fcsilli29", "Farkas Csilla", LocalDate.now());
				usersRepository.save(user1);
				usersRepository.save(user2);


				Job job1 = new Job("Programozo", 800000, "A programozók kódokat írnak és számítógépes alkalmazásokat fejlesztenek.", user1, LocalDate.now());
				Job job2 = new Job("Asztalos", 350000, "Az asztalos fa alapú bútorokat készít és javít.", user1, LocalDate.now());
				Job job3 = new Job("Ács", 400000, "Az ács faanyagból készülő építőipari szerkezeteket állít elő.", user1, LocalDate.now());
				Job job4 = new Job("Mosogató", 250000, "A mosogató edényekkel és tisztítószerekkel dolgozik.", user1, LocalDate.now());
				jobRepository.save(job1);
				jobRepository.save(job2);
				jobRepository.save(job3);
				jobRepository.save(job4);

				Job job5 = new Job("Szabó", 230000, "Szabó keményen dolgozik.", user2, LocalDate.now());
				Job job6 = new Job("Cukrász", 310000, "A cukrász kreatív édességeket készít és díszít, hogy azok élvezetet és örömet nyújtsanak az embereknek.", user2, LocalDate.now());
				Job job7 = new Job("Zenész", 200000, "A zenész hivatása az emberek szívébe és lelkébe énekelni vagy játszani.", user2, LocalDate.now());
				Job job8 = new Job("Lakatos", 290000, "A lakatos eredetileg zárak, lakatok, kulcsok illetve épület- vagy bútorvasalások készítésével illetve javításával foglalkozó szakember volt.", user2, LocalDate.now());
				jobRepository.save(job5);
				jobRepository.save(job6);
				jobRepository.save(job7);
				jobRepository.save(job8);

			}
		};

	}

}
