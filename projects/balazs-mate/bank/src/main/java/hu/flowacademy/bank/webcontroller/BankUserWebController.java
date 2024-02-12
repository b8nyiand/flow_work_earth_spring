package hu.flowacademy.bank.webcontroller;

import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/bank/user/")

public class BankUserWebController {

    @Autowired
    BankUserService bankUserService;

//    //---------------------------------------------------------------------------//
//
//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public BankUser save(@RequestBody BankUser bankUser) {
//        return bankUserService.save(bankUser);
//    }
//
//    //---------------------------------------------------------------------------//

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("allUser", bankUserService.findAll());
        return "users";
    }

//
//    @GetMapping("/findByUsername/{username}")
//    public BankUser findByUsername(@PathVariable String username) {
//        return bankUserService.findByUsername(username);
//    }
//
//    @GetMapping("/findByFullname/{fullname}")
//    public List<BankUser> findByFullname(@PathVariable String fullname) {
//        return bankUserService.findByFullname(fullname);
//    }
//
//
//    //---------------------------------------------------------------------------//
//
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public BankUser update(@RequestBody BankUser bankUser) {
//        return bankUserService.save(bankUser);
//    }
//
//    //---------------------------------------------------------------------------//
//
//    @Transactional
//    @DeleteMapping("/deleteByUsername/{username}")
//    public void deleteByUsername(@PathVariable String username) {
//        bankUserService.deleteByUsername(username);
//    }
//
//    //---------------------------------------------------------------------------//
//


}
