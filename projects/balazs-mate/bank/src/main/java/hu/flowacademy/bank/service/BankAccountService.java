package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.repository.BankAccountRepository;
import hu.flowacademy.bank.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    //---------------------------------------------------------------------------//

    public BankAccount save(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    //---------------------------------------------------------------------------//

    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }


    public List<BankAccount> findByBankUserUsername(String username) {
        return bankAccountRepository.findByBankUserUsername(username);
    }

    public List<BankAccount> findByBankUserFullname(String fullname) {
        return bankAccountRepository.findByBankUserFullname(fullname);
    }

    public BankAccount findById(Long id) {
        return bankAccountRepository.findById(id).orElseThrow();
    }


    //---------------------------------------------------------------------------//

    //---------------------------------------------------------------------------//

    public void deleteById(Long id) {
        bankAccountRepository.deleteById(id);
    }

    //---------------------------------------------------------------------------//


}
