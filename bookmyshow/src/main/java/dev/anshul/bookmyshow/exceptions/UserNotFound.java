package dev.anshul.bookmyshow.exceptions;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String msg) {
        super(msg);
    }
}
