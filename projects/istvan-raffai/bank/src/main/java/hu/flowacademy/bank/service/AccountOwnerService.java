package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.AccountOwner;
import hu.flowacademy.bank.repository.AccountOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountOwnerService {

    @Autowired
    private AccountOwnerRepository accountOwnerRepository;

    public AccountOwner addNewAccountOwner(AccountOwner owner) {
        return accountOwnerRepository.save(owner);
    }

    public AccountOwner updateAccountOwner(AccountOwner owner) {
        return accountOwnerRepository.save(owner);
    }

    public void deleteOwnerByUserName(String userName) {
        Optional<AccountOwner> ownerToDelete = accountOwnerRepository.findById(userName);
        if (ownerToDelete.isPresent())
            accountOwnerRepository.deleteById(userName);
        else {
            System.out.println("Nem létezik bankszámla-tulajdonos ezzel a felhasználónévvel!");
        }
    }

    public List<AccountOwner> listAllAccountOwners() {
        if (accountOwnerRepository.findAll().isEmpty()) {
            System.out.println("A számlatulajdonosok listája jelenleg teljesen üres!");
        }
        return accountOwnerRepository.findAll();
    }
    public List<AccountOwner> findByFullName(String fullName){
       List<AccountOwner> accountOwners = accountOwnerRepository.findByFullName(fullName);
       if (accountOwners != null && !accountOwners.isEmpty()){
           return accountOwners;
       }
       else {
           System.out.println("Nincs ilyen számlatulajdonos!");
           return null;
       }
    }

}

