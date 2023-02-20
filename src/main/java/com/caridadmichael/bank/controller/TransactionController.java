package com.caridadmichael.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caridadmichael.bank.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	private final TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}


}
