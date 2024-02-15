package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BankUserService {

    @Autowired
    BankUserRepository bankUserRepository;

    //---------------------------------------------------------------------------//

    public BankUser save(BankUser bankUser) {
        if (bankUser.getCreationDate() == null) {
            bankUser.setCreationDate(LocalDate.now());
        }
        return bankUserRepository.save(bankUser);
    }

    //---------------------------------------------------------------------------//

    public List<BankUser> findAll() {
        return bankUserRepository.findAll();
    }

    public BankUser findByUsername(String username) {
        return bankUserRepository.findByUsername(username);
    }


    public List<BankUser> findByFullname(String fullname) {
        return bankUserRepository.findByFullname(fullname);
    }


    public List<BankUser> findByOptionalFUEA(String fullname, String username, String email, String address) {
        return bankUserRepository.findByOptionalFUEA(fullname, username, email, address);
    }


    //---------------------------------------------------------------------------//


    public void deleteByUsername(String username) {
        bankUserRepository.deleteByUsername(username);
    }


    //---------------------------------------------------------------------------//


}
