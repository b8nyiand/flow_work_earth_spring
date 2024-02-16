package hu.flowacademy.bank;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.Customer;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.CustomerRepository;
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
    private CustomerRepository customerRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            if (customerRepository.findAll().isEmpty()) {
                Customer customer1 = new Customer("customer1", "Customer One", LocalDate.now());
                Customer customer2 = new Customer("customer2", "Customer Two", LocalDate.now());
                customerRepository.save(customer1);
                customerRepository.save(customer2);


                BankAccount account1 = new BankAccount("123456", 5000, "HUF", customer1, LocalDate.now(), "customer1");
                BankAccount account2 = new BankAccount("23456778",35100,"EUR",customer2,LocalDate.now(),"customer2");
                bankAccountRepository.save(account1);
                bankAccountRepository.save(account2);
            }
        };
    }
}
