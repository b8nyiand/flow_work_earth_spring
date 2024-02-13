package hu.flowacademy.bank.config;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.User;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, BankAccountRepository bankAccountRepository) {
        return args -> {
            User user1 = new User("user1", "User One", LocalDate.now());
            User user2 = new User("user2", "User Two", LocalDate.now());
            userRepository.save(user1);
            userRepository.save(user2);

            BankAccount account1 = new BankAccount("123456", 5000, "HUF", user1, LocalDate.now());
            BankAccount account2 = new BankAccount("654321", 10000, "EUR", user2, LocalDate.now());
            bankAccountRepository.save(account1);
            bankAccountRepository.save(account2);
        };
    }
}