package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.Customer;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount createBankAccount(String username, BankAccount bankAccount) {
        Customer customer = (Customer) customerRepository.findByUsername(username);
        if (customer != null) {
            bankAccount.setCustomer(customer);
            return bankAccountRepository.save(bankAccount);
        } else {
            throw new RuntimeException("Hiba");

        }
    }


    public BankAccount updateBankAccount(BankAccount updatedBankAccount) {
        return bankAccountRepository.save(updatedBankAccount);
    }

    public void deleteBankAccount(Long id){
        bankAccountRepository.deleteById(id);
    }

    public BankAccount findByAccountId(Long id){
        return bankAccountRepository.findById(id).orElse(null);
    }

    public List<BankAccount> listAllBankAccounts(){
        return bankAccountRepository.findAll();
    }
}
