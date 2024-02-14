package hu.flowacademy.ads;

import hu.flowacademy.ads.model.Ad;
import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.repository.AdRepository;
import hu.flowacademy.ads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdsApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	AdRepository adRepository;

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			if (userRepository.findAll().isEmpty()) {
				User user1 = new User("macilaci", "Medve László", LocalDate.now());
				User user2 = new User("atomanti", "Atom Antal", LocalDate.now());
				User user3 = new User("kovácsferi", "Kovács Ferenc", LocalDate.now());

				userRepository.save(user1);
				userRepository.save(user2);
				userRepository.save(user3);

				Ad ad1 = new Ad("bojler", 50000, "Bojler eladó!", LocalDate.now(), user1);
				Ad ad2 = new Ad("álombojler", 60000, "Álmaid bojlere vár, hívj még ma! A számom 06/90...", LocalDate.now(), user2);
				Ad ad3 = new Ad("kavics", 300, "Nagyon szép kavics kapható nálam, egyenesen a Tiszából!", LocalDate.now(), user2);
				Ad ad4 = new Ad("iphone4s", 20000, "Alig használt iPhone 4s eladó!", LocalDate.now(), user3);
				Ad ad5 = new Ad("moncsicsi", 2500, "Gyerekkori moncsicsim eladó!", LocalDate.now(), user3);
				Ad ad6 = new Ad("ház", 50000000, "Ház eladó!", LocalDate.now(), user3);

				adRepository.save(ad1);
				adRepository.save(ad2);
				adRepository.save(ad3);
				adRepository.save(ad4);
				adRepository.save(ad5);
				adRepository.save(ad6);

			}
		};
	}
}
