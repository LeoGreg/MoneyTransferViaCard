package com.example.money.advice;

import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.card.except.DuplicateCardNumber;
import com.example.money.util.exception.transfer.excep.IllegalDoingException;
import com.example.money.util.exception.transfer.excep.SameCardNumbersException;
import com.example.money.util.exception.transfer.excep.WrongBalanceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Log4j2
@ControllerAdvice
public class ExceptionToStatusHandler {

    @ResponseBody
    @ExceptionHandler(DuplicateCardNumber.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String dup(DuplicateCardNumber number) {
        log.info(">>>" + number.getMessage() + ":");
        return number.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CardNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String not(CardNotFoundException e) {
        log.info(">>>" + e.getMessage() + ":");
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(WrongBalanceException.class)
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    String w1(WrongBalanceException e) {
        log.info(">>>" + e.getMessage() + ":");
        return e.getMessage();
    }


    @ResponseBody
    @ExceptionHandler(SameCardNumbersException.class)
    @ResponseStatus(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
    String i(SameCardNumbersException e) {
        log.info(">>>" + e.getMessage() + ":");
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(IllegalDoingException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String il(IllegalDoingException e) {
        log.info(">>>" + e.getMessage() + ":");
        return e.getMessage();
    }
}
