package hu.flowacademy.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ExceptionGeneral {

    @ExceptionHandler
    public String exception(Exception ex, Model model) {
        model.addAttribute("exception_message", ex.getMessage());
        model.addAttribute("exception_stacktrace", getStackTraceAsString(ex));
        return "response";
    }

    private String getStackTraceAsString(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }
}