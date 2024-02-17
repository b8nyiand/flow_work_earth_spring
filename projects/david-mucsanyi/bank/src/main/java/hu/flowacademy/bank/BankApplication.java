package hu.flowacademy.bank;

import hu.flowacademy.bank.model.User;
import hu.flowacademy.bank.repository.BankAccountRepositry;
import hu.flowacademy.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BankApplication {

	@Autowired
	public UserRepository userRepository;
	@Autowired
	public BankAccountRepositry bankAccountRepositry;


	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			User user = new User("Superadmin", "Veszt Elek", LocalDate.now());
			User user1 = new User("Treinee", "Kaszab Márton", LocalDate.now());
			User user2 = new User("Supervisor", "Tóth Jázmin", LocalDate.now());
			User user3 = new User("Useradmin", "Lakatos Rambó", LocalDate.now());
			userRepository.save(user);
		};
	}



}
