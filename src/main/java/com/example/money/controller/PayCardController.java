package com.example.money.controller;

import com.example.money.configs.SecurityContextProvider;
import com.example.money.model.active.PayCard;
import com.example.money.model.info.User;
import com.example.money.service.abst.PayCardService;
import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.card.except.DuplicateCardNumber;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/api/card")
public class PayCardController {

    @Autowired
    private PayCardService payCardService;

    @Autowired
    private SecurityContextProvider provider;

    @PostMapping("/reg")
    public ResponseEntity sign_up(@Valid @RequestBody PayCard payCard, OAuth2Authentication oAuth2Authentication) throws DuplicateCardNumber, DuplicateCardNumber {
        User user = provider.getByAuthentication(oAuth2Authentication);
        payCardService.sign_up(payCard, user.getName(),user.getSurname(),user.getId());
        return ResponseEntity.ok(payCard);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(payCardService.getAll());
    }

    @GetMapping("/byNum/{number}")
    public ResponseEntity getByNumber(@PathVariable String number) throws CardNotFoundException {
        return ResponseEntity.ok(payCardService.getByNumber(number));
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity getById(@PathVariable int id) throws CardNotFoundException {
        return ResponseEntity.ok(payCardService.getById(id).orElseThrow(() -> new CardNotFoundException("no.card")));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity removeTheCard(@PathVariable int id) {
        payCardService.removeCard(id);
        return ResponseEntity.noContent().build();
    }
}
