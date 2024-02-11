package hu.flowacademy.ads.exceptionHandler;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }
}
