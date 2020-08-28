package com.example.money.service.impl;


import com.example.money.model.active.PayCard;
import com.example.money.repository.PayCardRepository;
import com.example.money.service.abst.PayCardService;

import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.card.except.DuplicateCardNumber;
import com.example.money.util.exception.card.handler.PayCardExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PayCardServiceImpl implements PayCardService {

    @Autowired
    private PayCardRepository payCardRepository;

    @Override
    @Transactional
    public void sign_up(PayCard payCard, String name,String surname,int userId) throws DuplicateCardNumber {
        PayCard possiblyDuplicated = payCardRepository.getByNumber(payCard.getNumber());
        PayCardExceptionHandler.isDuplicated(possiblyDuplicated);
        payCard.setUserName(name);
        payCard.setUserSurname(surname);
        payCard.setUserId(userId);
        payCardRepository.save(payCard);
    }


    @Override
    @Transactional
    public void removeCard(int id) {
        payCardRepository.deleteById(id);
    }

    @Override
    public List<PayCard> getAll() {
        return payCardRepository.findAll();
    }

    @Override
    public PayCard getByNumber(String number) throws CardNotFoundException {
        PayCardExceptionHandler.checkToSeeIfNotExisted(payCardRepository.getByNumber(number));
        return payCardRepository.getByNumber(number);
    }

    @Override
    public Optional<PayCard> getById(int id) {
        return payCardRepository.getById(id);
    }

}
