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

    //---------------------------------------------------------------------------//

    @GetMapping("/add")
    public String showForm(Model model) {
        BankUser bankUser = new BankUser();
        model.addAttribute("user", bankUser);
        return "register_user";
    }

    @PostMapping("/add")
    public String acceptForm(@ModelAttribute("user") BankUser bankUser) {
        bankUserService.save(bankUser);
        return "user_info";
    }

    //---------------------------------------------------------------------------//

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("allUser", bankUserService.findAll());
        return "users";
    }

    @GetMapping("/search")
    public String findByOptionalFUA() {
        return "users";
    }

    @PostMapping("/search")
    public String acceptSearch(Model model, @RequestParam(required = false, name = "fullname") String fullname, @RequestParam(required = false, name = "username") String username, @RequestParam(required = false, name = "email") String email, @RequestParam(required = false, name = "address") String address) {
        model.addAttribute("allUser", bankUserService.findByOptionalFUEA(fullname, username, email, address));
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
