package com.example.money.repository;

import com.example.money.model.active.PayCard;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayCardRepository extends JpaRepository<PayCard, Integer> {

    PayCard getByNumber(String number);

    Optional<PayCard> getById(int id);


    boolean existsByNumberAndUserId(String num,int id);
}
