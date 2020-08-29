package com.example.money.service.abst;

import com.example.money.model.active.TransferStory;
import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.transfer.excep.IllegalDoingException;
import com.example.money.util.exception.transfer.excep.SameCardNumbersException;
import com.example.money.util.exception.transfer.excep.WrongBalanceException;

import javax.transaction.Transactional;
import java.util.List;

public interface TransferService {


    @Transactional
    void transfer(TransferStory transferStory, String name, String surname, int senderId, String username) throws CardNotFoundException, WrongBalanceException, SameCardNumbersException, IllegalDoingException;

    List<TransferStory> getAll();

}
