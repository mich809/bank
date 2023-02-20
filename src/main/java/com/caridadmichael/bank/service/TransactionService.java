package com.caridadmichael.bank.service;

import org.springframework.stereotype.Service;

import com.caridadmichael.bank.repository.TransactionRepo;

@Service
public class TransactionService {
	private final TransactionRepo transactionRepo;
	
	public TransactionService(TransactionRepo transactionRepo) {
		this.transactionRepo = transactionRepo;
		
	}

}
