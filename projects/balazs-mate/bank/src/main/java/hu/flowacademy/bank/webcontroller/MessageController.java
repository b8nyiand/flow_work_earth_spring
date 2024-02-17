package hu.flowacademy.bank.webcontroller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MessageController implements ErrorController {

    @GetMapping("/web/bank/message/action")
    public String printSuccessfullMessage() {

        return "response";
    }

    @RequestMapping("/error")
    public String handleError() {
        return "error_404";
    }

}

