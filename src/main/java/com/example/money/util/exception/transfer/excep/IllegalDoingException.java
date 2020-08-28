package com.example.money.util.exception.transfer.excep;

public class IllegalDoingException extends Exception {

    public IllegalDoingException(String message) {
        super(message);
    }

    public static void check(boolean ex, String message) throws IllegalDoingException {
        if (ex) {
            throw new IllegalDoingException(message);
        }
    }
}
