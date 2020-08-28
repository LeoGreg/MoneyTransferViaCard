package com.example.money.util.exception.card.handler;

import com.example.money.model.active.PayCard;
import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.card.except.DuplicateCardNumber;

public class PayCardExceptionHandler {

    public static void isDuplicated(PayCard possibleDuplicated) throws DuplicateCardNumber {
        DuplicateCardNumber.check(possibleDuplicated != null, "duplicate.card");
    }

    public static void checkToSeeIfNotExisted(PayCard payCard) throws CardNotFoundException {
        CardNotFoundException.check(payCard == null, "no.card");
    }
}
