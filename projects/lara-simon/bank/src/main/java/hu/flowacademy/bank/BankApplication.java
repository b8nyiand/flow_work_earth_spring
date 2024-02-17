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
                User user1 = new User("kallaya", "Kallay Andris", LocalDate.now());
                userRepository.save(user1);
                BankAccount bankAccount1 = new BankAccount("abc", 500, "HUF", "kallaya", LocalDate.now(), user1);
                bankAccountRepository.save(bankAccount1);

                User user2 = new User("ssimonlara", "Simon Lara", LocalDate.now());
                userRepository.save(user2);
                BankAccount bankAccount2 = new BankAccount("def", 4000, "EUR", "ssimonlara", LocalDate.now(), user2);
                bankAccountRepository.save(bankAccount2);

                User user3 = new User("kiskutya", "Kis Kutya", LocalDate.now());
                userRepository.save(user3);
                BankAccount bankAccount3 = new BankAccount("ghi", 2000, "HUF", "kiskutya", LocalDate.now(), user3);
                bankAccountRepository.save(bankAccount3);

                User user4 = new User("valaki", "Valaki valaki", LocalDate.now());
                userRepository.save(user4);
                BankAccount bankAccount4 = new BankAccount("jkl", 10000, "EUR", "valaki", LocalDate.now(), user4);
                bankAccountRepository.save(bankAccount4);
            }
        };
    }
}
