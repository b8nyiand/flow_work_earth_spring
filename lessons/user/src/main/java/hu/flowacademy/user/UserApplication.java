package hu.flowacademy.user;

import hu.flowacademy.user.model.User;
import hu.flowacademy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner runner() {
		return args -> {
			User user = new User("admin", "Admin", "ADMIN", 670);

			userRepository.save(user);
		};
	}*/
}
