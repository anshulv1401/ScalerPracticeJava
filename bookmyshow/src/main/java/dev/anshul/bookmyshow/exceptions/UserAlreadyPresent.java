package dev.anshul.bookmyshow.exceptions;

public class UserAlreadyPresent extends RuntimeException {

    public UserAlreadyPresent(String msg) {
        super(msg);
    }
}
