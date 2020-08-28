package com.example.money.util.exception.transfer.excep;

public class SameCardNumbersException extends Exception {

    public SameCardNumbersException(String message) {
        super(message);
    }

    public static void checkLegalRule(boolean ex, String message) throws SameCardNumbersException {
        if (ex) {
            throw new SameCardNumbersException(message);
        }
    }

}
