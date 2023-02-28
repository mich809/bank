package com.caridadmichael.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caridadmichael.bank.model.Transaction;
import com.caridadmichael.bank.model.TransactionType;
import com.caridadmichael.bank.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
@CrossOrigin
public class TransactionController {
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	private final TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
		
	}
	
	@GetMapping("/{id}")
	public List<Transaction> getAllTransactions(@PathVariable Long id){
		logger.info(String.format("fetching all transactions"));
		return transactionService.getAllTransactions(id);
	}
	
	@GetMapping("/{id}/{transactionType}")
	public List<Transaction> getAllTransactionsByType(@PathVariable Long id, @PathVariable TransactionType transactionType){
		logger.info(String.format("fetching all transactions of type %s",transactionType));
		return transactionService.getAllTransactionsByType(id , transactionType);
	}
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
		logger.info(String.format("adding transaction to account: %s ",id));
		transactionService.addTransaction(id,transaction);
	}


}
