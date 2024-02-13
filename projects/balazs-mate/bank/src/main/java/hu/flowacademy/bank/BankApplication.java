package hu.flowacademy.bank;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.BankUserRepository;
import hu.flowacademy.bank.service.BankAccountService;
import hu.flowacademy.bank.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

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

                BankUser user01 = new BankUser("bmate", "Balázs Máté", LocalDate.of(2012,4,22));
                BankAccount account01 = new BankAccount("01010101", 500000, Currency.HUF, user01);

                bankUserService.save(user01);
                bankAccountService.save(account01);

                BankUser user02 = new BankUser("kzolt", "Zoltán Kovács", LocalDate.of(2015,12,20));
                BankAccount account02 = new BankAccount("0101000101", 100000, Currency.HUF, user02);

                bankUserService.save(user02);
                bankAccountService.save(account02);

                BankUser user03 = new BankUser("pferenc", "Ferenc Papp", LocalDate.of(2019,9,2));
                BankAccount account03 = new BankAccount("010100550101", 230000, Currency.EUR, user03);

                bankUserService.save(user03);
                bankAccountService.save(account03);;

                System.out.println("Successfully finished with CommandLineRunner.");
                System.out.println("Ready to work");
            }
        };
    }

}
