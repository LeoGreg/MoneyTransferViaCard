package com.example.money.service.impl;

import com.example.money.model.active.PayCard;
import com.example.money.model.active.TransferStory;
import com.example.money.repository.PayCardRepository;
import com.example.money.repository.TransferRepository;
import com.example.money.service.abst.TransferService;
import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.card.handler.PayCardExceptionHandler;
import com.example.money.util.exception.transfer.excep.IllegalDoingException;
import com.example.money.util.exception.transfer.excep.SameCardNumbersException;
import com.example.money.util.exception.transfer.excep.WrongBalanceException;
import com.example.money.util.exception.transfer.handler.TransferExceptionHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class TransferServiceImpl implements TransferService {


    

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private PayCardRepository payCardRepository;

    @Override
    @Transactional
    public void transfer(TransferStory transferStory, String name, String surname, int senderId) throws CardNotFoundException, WrongBalanceException, SameCardNumbersException, IllegalDoingException {
        IllegalDoingException.check(!payCardRepository.existsByNumberAndUserId(transferStory.getSenderN(), senderId), "illegal.transfer");

        PayCard sender = payCardRepository.getByNumber(transferStory.getSenderN());
        PayCard getter = payCardRepository.getByNumber(transferStory.getGetterN());

        PayCardExceptionHandler.checkToSeeIfNotExisted(sender);
        PayCardExceptionHandler.checkToSeeIfNotExisted(getter);
        TransferExceptionHandler.isZero(sender);
        TransferExceptionHandler.areNumsTheSame(sender, getter);
        TransferExceptionHandler.isNotEnoughForFulfillingTransaction(sender, transferStory.getMoney());
        TransferExceptionHandler.isTransferringMoneyValid(transferStory.getMoney());

        transferStory.setSenderBalanceBeforeTransaction(sender.getBalance());
        transferStory.setGetterBalanceBeforeTransaction(getter.getBalance());

        sender.setBalance(sender.getBalance() - transferStory.getMoney());
        getter.setBalance(getter.getBalance() + transferStory.getMoney());
        payCardRepository.save(sender);
        payCardRepository.save(getter);

        transferStory.setSenderBalanceAfterTransaction(sender.getBalance());
        transferStory.setGetterBalanceAfterTransaction(getter.getBalance());

        transferStory.setSenderName(name);
        transferStory.setSenderSurname(surname);
        transferStory.setSenderId(senderId);
        transferRepository.save(transferStory);
    }

    @Override
    public List<TransferStory> getAll() {
        return transferRepository.findAll();
    }


}

