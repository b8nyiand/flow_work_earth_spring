package hu.flowacademy.bank;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.AccountOwner;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.AccountOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BankApplication {

    @Autowired
    private AccountOwnerRepository accountOwnerRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }



    @Bean
    public CommandLineRunner runner() {
        return args -> {
            if (accountOwnerRepository.findAll().isEmpty()) {
                AccountOwner accountOwner1 = new AccountOwner("pittypalatty", "Mosó Masa", LocalDate.now());
                accountOwnerRepository.save(accountOwner1);

                BankAccount bankAccount1 = new BankAccount("0123456", 5600, "EUR", LocalDate.now(), accountOwner1);
                BankAccount bankAccount2 = new BankAccount("9123456", 1_300_000, "HUF", LocalDate.now(), accountOwner1);

                bankAccountRepository.save(bankAccount1);
                bankAccountRepository.save(bankAccount2);
            }
        };
    }
}



