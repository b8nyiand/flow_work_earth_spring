package hu.flowacademy.bank.exceptions;

import hu.flowacademy.bank.model.Currency;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionGeneral {

    @ExceptionHandler
    public String exception(Exception ex, Model model) {
        String messageForUser = null;

        if (ex instanceof MethodArgumentTypeMismatchException) {
            messageForUser = "Wrong input, please fill the 'balance' field with an integer (max 10 digit long)!";
        }
        if (ex instanceof DateTimeParseException) {
            messageForUser = "Wrong date format, please use the following: '1980-01-01'";
        }
        if (ex instanceof IllegalArgumentException && ex.getMessage().contains("No enum constant")) {
            messageForUser = "Wrong currency format or non-existing currency. Please use one of the following:";
            messageForUser += Arrays.toString(Currency.values());
        }



        model.addAttribute("exception_messageForUser", messageForUser);
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