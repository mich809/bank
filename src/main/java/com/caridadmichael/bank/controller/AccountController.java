package com.caridadmichael.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caridadmichael.bank.model.Account;
import com.caridadmichael.bank.service.AccountService;
import com.caridadmichael.bank.service.TokenService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	private final AccountService accountService;
	
	
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
		
	}
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAccount(@PathVariable Long id ,@RequestBody Account account) {
		logger.info(String.format("creating %s account for customer id: %s ", account.getAccountType(),id));
		accountService.createAccount(id, account);
	}
	
	

	
	

}
