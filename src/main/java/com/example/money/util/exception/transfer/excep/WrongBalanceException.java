package com.example.money.util.exception.transfer.excep;

import com.example.money.util.exception.card.except.CardNotFoundException;

public class WrongBalanceException extends Exception {

    public WrongBalanceException(String message) {
        super(message);
    }

    public static void checkBalance(boolean ex, String message) throws WrongBalanceException {
        if (ex) {
            throw new WrongBalanceException(message);
        }
    }
}
