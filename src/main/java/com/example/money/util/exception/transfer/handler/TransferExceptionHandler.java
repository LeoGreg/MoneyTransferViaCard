package com.example.money.util.exception.transfer.handler;

import com.example.money.model.active.PayCard;
import com.example.money.util.exception.transfer.excep.SameCardNumbersException;
import com.example.money.util.exception.transfer.excep.WrongBalanceException;

import static com.example.money.util.messages.ExceptionMessage.*;

public class TransferExceptionHandler {

    public static void isZero(PayCard sender) throws WrongBalanceException {
        WrongBalanceException.checkBalance(sender.getBalance() == 0, ZERO_BALANCE);
    }

    public static void isNotEnoughForFulfillingTransaction(PayCard sender, double inputMoney) throws WrongBalanceException {
        WrongBalanceException.checkBalance(sender.getBalance() - inputMoney < 0, NOT_ENOUGH_BALANCE);
    }

    public static void areNumsTheSame(PayCard sender, PayCard getter) throws SameCardNumbersException {
        SameCardNumbersException.checkLegalRule(sender.getNumber() == getter.getNumber(), ILLEGAL_TRANSFER);
    }

    public static void isTransferringMoneyValid(double money) throws WrongBalanceException {
        WrongBalanceException.checkBalance(money < 0, WRONG_CASH_INSERT);
    }
}
