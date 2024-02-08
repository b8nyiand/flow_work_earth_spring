package hu.flowacademy.bank;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    BankUserRepository bankUserRepository;

    @Bean
    public CommandLineRunner runner() {
        return args -> {

            if (bankUserRepository.findAll().isEmpty()) {

                BankUser user01 = new BankUser("bmate", "Balázs Máté");
                BankAccount account01 = new BankAccount("01010101", 500000, Currency.HUF, user01);

                bankUserRepository.save(user01);
                bankAccountRepository.save(account01);

                BankUser user02 = new BankUser("kzolt", "Zoltán Kovács");
                BankAccount account02 = new BankAccount("0101000101", 100000, Currency.HUF, user02);

                bankUserRepository.save(user02);
                bankAccountRepository.save(account02);

                System.out.println("Successfully finished with CommandLineRunner.");
                System.out.println("Ready to work");
            }
        };
    }

}
