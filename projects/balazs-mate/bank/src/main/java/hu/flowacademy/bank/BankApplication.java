package hu.flowacademy.bank;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hu.flowacademy.bank.function.Initializer;
import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.service.BankAccountService;
import hu.flowacademy.bank.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Autowired
    BankAccountService bankAccountService;
    @Autowired
    BankUserService bankUserService;

    @Bean
    public CommandLineRunner runner() {
        return args -> {

            if (bankUserService.findAll().isEmpty()) {
                System.out.println("The repositories are empty.");
                System.out.println("Upload initial data");

                BankUser user01 = new BankUser("bmate", "Balázs Máté", LocalDate.of(2012, 4, 22), true);
                BankAccount account01a = new BankAccount(500000, Currency.HUF, LocalDate.of(2011, 12, 20), user01);
                BankAccount account01b = new BankAccount(50000, Currency.USD, LocalDate.of(2012, 12, 21), user01);

                bankUserService.save(user01);
                bankAccountService.save(account01a);
                bankAccountService.save(account01b);

                BankUser user02 = new BankUser("kzolt", "Zoltán Kovács", LocalDate.of(2015, 12, 20));
                BankAccount account02 = new BankAccount(100000, Currency.HUF, LocalDate.of(2013, 12, 22), user02);

                bankUserService.save(user02);
                bankAccountService.save(account02);

                BankUser user03 = new BankUser("pferenc", "Ferenc Papp", LocalDate.of(2019, 9, 2));
                BankAccount account03 = new BankAccount(230000, Currency.EUR, LocalDate.of(2014, 01, 10), user03);

                bankUserService.save(user03);
                bankAccountService.save(account03);

                Initializer.populateRepositories().stream().forEach(bankUser -> bankUserService.save(bankUser));

                System.out.println("Successfully finished with CommandLineRunner.");
                System.out.println("Ready to work");

            }
        };
    }

}
