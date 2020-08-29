package com.example.money.util.exception.card.handler;

import com.example.money.model.active.PayCard;
import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.card.except.DuplicateCardNumber;

import static com.example.money.util.messages.ExceptionMessage.DUPLICATE_CARD;
import static com.example.money.util.messages.ExceptionMessage.NOT_FOUND;

public class PayCardExceptionHandler {

    public static void isDuplicated(PayCard possibleDuplicated) throws DuplicateCardNumber {
        DuplicateCardNumber.check(possibleDuplicated != null, DUPLICATE_CARD);
    }

    public static void checkToSeeIfNotExisted(PayCard payCard) throws CardNotFoundException {
        CardNotFoundException.check(payCard == null, NOT_FOUND);
    }
}
