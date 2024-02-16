package hu.flowacademy.bank.webcontroller;

import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.model.Currency;
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
    @Autowired
    MessageController messageController;

    //---------------------------------------------------------------------------//

    @GetMapping("/add")
    public String getForm(Model model) {
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

    @GetMapping("/search")
    public String findByOptionalFUA() {
        return "users";
    }

    @PostMapping("/search")
    public String acceptSearch(Model model, @RequestParam(required = false, name = "fullname") String fullname, @RequestParam(required = false, name = "username") String username, @RequestParam(required = false, name = "email") String email, @RequestParam(required = false, name = "address") String address) {
        model.addAttribute("allUser", bankUserService.findByOptionalFUEA(fullname, username, email, address));
        return "users";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("allUser", bankUserService.findAll());
        return "users";
    }

    @GetMapping("/findByUsername/{username}")
    public String findByUsername(Model model, @PathVariable String username) {
        model.addAttribute("user", bankUserService.findByUsername(username));
        model.addAttribute("currencies", Currency.values());
        return "user_info";
    }

//    //---------------------------------------------------------------------------//
//
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public BankUser update(@RequestBody BankUser bankUser) {
//        return bankUserService.save(bankUser);
//    }
//
    //---------------------------------------------------------------------------//

    @Transactional
    @GetMapping("/deleteByUsername/{username}")
    public String deleteByUsername(@PathVariable String username) {

        //create a boolean: isSuccessful, and this will the input of the printMessage method
        bankUserService.deleteByUsername(username);
        return "redirect:/web/bank/message/action";
    }

    @Transactional
    @PostMapping("/deleteByUsername")
    public String deleteByUsernameGeneral(@RequestParam(name = "username") String username) {

        //create a boolean: isSuccessful, and this will the input of the printMessage method
        bankUserService.deleteByUsername(username);
        return messageController.printMessage();
    }

}
