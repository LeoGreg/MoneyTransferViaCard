package com.example.money.util.exception.card.except;

public class DuplicateCardNumber extends Exception {

    public DuplicateCardNumber(String message) {
        super(message);
    }

    public static void check(boolean ex, String message) throws DuplicateCardNumber {
        if (ex) {
            throw new DuplicateCardNumber(message);
        }
    }
}
