package com.caridadmichael.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caridadmichael.bank.model.Account;

@RestController
@RequestMapping("v1/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);


	@PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		logger.info("Account Created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
