package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.AccountOwner;
import hu.flowacademy.bank.model.BankAccount;
import hu.flowacademy.bank.repository.AccountOwnerRepository;
import hu.flowacademy.bank.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    public BankAccountRepository bankAccountRepository;

    @Autowired
    public AccountOwnerRepository accountOwnerRepository;

    public BankAccount addNewAccount(BankAccount bankAccount, String userName) {
        AccountOwner accountOwner = accountOwnerRepository.findById(userName).orElse(null);
        if (accountOwner == null) {
            throw new RuntimeException("Nincs ilyen számlatulajdonos");
        }
        bankAccount.setAccountOwner(accountOwner);
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount updateAccount(BankAccount bankAccount, String userName, Long id) {

        AccountOwner accountOwner = accountOwnerRepository.findById(userName).orElse(null);
        if (accountOwner == null) {
            throw new RuntimeException("Nincs ilyen számlatulajdonos");
        }

       BankAccount oldAccount = accountOwner.getAccounts().stream().filter(x->x.getId().equals(id)).findAny().orElse(null);
       accountOwner.getAccounts().remove(oldAccount);

        if (id == null) {
            throw new RuntimeException("Az id nem kaphat nullértéket");
        }

        bankAccount.setId(id);

        bankAccount.setAccountOwner(accountOwner);
        return bankAccountRepository.save(bankAccount);
    }

    public void deleteAccountById(Long id) {
        bankAccountRepository.deleteById(String.valueOf(id));
    }

    public List<BankAccount> accountList(String userName) {
        Optional<AccountOwner> optionalAccountOwner = accountOwnerRepository.findById(userName);
        if (optionalAccountOwner.isPresent()) {
            return optionalAccountOwner.get().getAccounts();
        } else return Collections.emptyList();
    }

    public BankAccount findById(Long id) {
        return bankAccountRepository.findById(String.valueOf(id)).orElse(null);
    }
}
