package com.example.money.service.abst;

import com.example.money.model.active.PayCard;
import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.card.except.DuplicateCardNumber;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PayCardService {

    @Transactional
    void sign_up(PayCard payCard, String name, String surname, int userId) throws DuplicateCardNumber;

    @Transactional
    void removeCard(int id);

    List<PayCard> getAll();

    PayCard getByNumber(String number) throws CardNotFoundException, CardNotFoundException;

    Optional<PayCard> getById(int id);
}
