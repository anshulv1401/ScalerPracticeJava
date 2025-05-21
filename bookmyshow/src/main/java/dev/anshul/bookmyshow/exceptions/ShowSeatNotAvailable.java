package dev.anshul.bookmyshow.exceptions;

public class ShowSeatNotAvailable extends RuntimeException {

    public ShowSeatNotAvailable(String msg) {
        super(msg);
    }
}
