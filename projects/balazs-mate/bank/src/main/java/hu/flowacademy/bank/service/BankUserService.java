package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankUserService {

    @Autowired
    BankUserRepository bankUserRepository;

    //---------------------------------------------------------------------------//

    public BankUser save(BankUser bankUser) {
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


    //---------------------------------------------------------------------------//


    public void deleteByUsername(String username) {
        bankUserRepository.deleteByUsername(username);
    }


    //---------------------------------------------------------------------------//


}
