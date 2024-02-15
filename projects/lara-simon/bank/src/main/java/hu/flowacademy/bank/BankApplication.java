package hu.flowacademy.bank;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.User;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            if (userRepository.findAll().isEmpty()) {

                User user = new User("username", "User Name", LocalDate.now());
                userRepository.save(user);
                User userEn = new User("ssimonlara", "Simon Lara", LocalDate.now());
                userRepository.save(userEn);

                BankAccount bankAccount = new BankAccount("num", 500, "HUF", "username", LocalDate.now(), user);
                bankAccountRepository.save(bankAccount);
                BankAccount bankAccountEn = new BankAccount("num", 4000, "EUR", "simonlara", LocalDate.now(), userEn);
                bankAccountRepository.save(bankAccountEn);
            }
        };
    }
}
