package hu.flowacademy.bank.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/bank/message/")
public class MessageController {

    @GetMapping("/action")
    public String printMessage() {
        //Exception handling!

        return "response";
    }

}
