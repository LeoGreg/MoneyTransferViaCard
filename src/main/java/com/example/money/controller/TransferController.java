package com.example.money.controller;

import com.example.money.configs.SecurityContextProvider;
import com.example.money.model.active.PayCard;
import com.example.money.model.active.TransferStory;
import com.example.money.model.info.User;
import com.example.money.service.abst.TransferService;
import com.example.money.util.exception.card.except.CardNotFoundException;
import com.example.money.util.exception.transfer.excep.IllegalDoingException;
import com.example.money.util.exception.transfer.excep.SameCardNumbersException;
import com.example.money.util.exception.transfer.excep.WrongBalanceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/api/transfer")
public class TransferController {





    @Autowired
    private SecurityContextProvider securityContextProvider;

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity transfer(@Valid @RequestBody TransferStory transferStory, OAuth2Authentication oAuth2Authentication) throws SameCardNumbersException, WrongBalanceException, CardNotFoundException, IllegalDoingException {
        User sender = securityContextProvider.getByAuthentication(oAuth2Authentication);
        transferService.transfer(transferStory, sender.getName(), sender.getSurname(), sender.getId(),sender.getUsername());
        return ResponseEntity.ok(transferStory);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(transferService.getAll());
    }


}
