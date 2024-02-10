package hu.flowacademy.bank.controller;

import hu.flowacademy.bank.model.AccountOwner;
import hu.flowacademy.bank.service.AccountOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountOwner")
public class AccountOwnerController {

    @Autowired
    public AccountOwnerService accountOwnerService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountOwner addNewAccountOwner(@RequestBody AccountOwner owner) {
        return accountOwnerService.addNewAccountOwner(owner);
    }

    @PutMapping("/update")
    public AccountOwner updateAccountOwner(@RequestBody AccountOwner owner) {
        return accountOwnerService.updateAccountOwner(owner);
    }

    @DeleteMapping("/deleteByUserName/{userName}")
    public void deleteOwnerByUserName(@PathVariable String userName) {
        accountOwnerService.deleteOwnerByUserName(userName);

    }

    @GetMapping("/list")
    public List<AccountOwner> listAllAccountOwners() {
        return accountOwnerService.listAllAccountOwners();
    }

    @GetMapping("/findByFullName/{fullName}")
    public List<AccountOwner> findByFullName(@PathVariable String fullName) {
        return accountOwnerService.findByFullName(fullName);
    }
}
