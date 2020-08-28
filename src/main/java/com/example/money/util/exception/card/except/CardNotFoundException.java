package com.example.money.util.exception.card.except;

public class CardNotFoundException extends Exception {

    public CardNotFoundException(String message) {
        super(message);
    }

    public static void check(boolean ex, String message) throws CardNotFoundException {
        if (ex) {
            throw new CardNotFoundException(message);
        }
    }
}
