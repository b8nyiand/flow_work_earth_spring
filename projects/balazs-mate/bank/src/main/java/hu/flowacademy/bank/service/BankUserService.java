package hu.flowacademy.bank.service;

import hu.flowacademy.bank.exceptions.UserRegistrationException;
import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
import hu.flowacademy.bank.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.Comparator;
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
        if (bankUserRepository.findByUsername(bankUser.getUsername()) != null) {
            throw new UserRegistrationException("This username is already used, be choose another one!");
        }
        if (bankUser.getUsername() == null || bankUser.getUsername().isEmpty()) {
            throw new UserRegistrationException("Empty username, please type a username in order to registrate!");
        }
        if (bankUser.getCreationDate() == null) {
            bankUser.setCreationDate(LocalDate.now());
        }
        if (bankUser.getAddress() == null || bankUser.getAddress().isEmpty()) {
            bankUser.setAddress(bankUser.getCountry() + ", " + bankUser.getCity());
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

    public List<BankUser> findByOptionalFUA(String fullname, String username, String address) {
        return bankUserRepository.findByOptionalFUA(fullname, username, address);
    }

    public List<BankUser> findByOptionalFUASorted(String fullname, String username, String address) {
        return bankUserRepository.findByOptionalFUA(fullname, username, address)
                .stream()
                .sorted(Comparator.comparing(BankUser::getFullname))
                .collect(Collectors.toList());
    }


    //---------------------------------------------------------------------------//
    public BankUser update(BankUser bankUser) {
        return bankUserRepository.save(bankUser);
    }

    //---------------------------------------------------------------------------//

    public void deleteByUsername(String username) {
        bankUserRepository.deleteByUsername(username);
    }

    //---------------------------------------------------------------------------//


}
