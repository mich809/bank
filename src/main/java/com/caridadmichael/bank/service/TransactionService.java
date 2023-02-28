package com.caridadmichael.bank.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.caridadmichael.bank.model.Account;
import com.caridadmichael.bank.model.Transaction;
import com.caridadmichael.bank.model.TransactionType;
import com.caridadmichael.bank.repository.AccountRepo;
import com.caridadmichael.bank.repository.TransactionRepo;

@Service
public class TransactionService {
	private final AccountRepo accountRepo;
	private final TransactionRepo transactionRepo;


	public TransactionService(AccountRepo accountRepo, TransactionRepo transactionRepo) {
		this.accountRepo = accountRepo;
		this.transactionRepo = transactionRepo;

	}

	public void addTransaction(Long id, Transaction transaction) {
		if (!(accountRepo.existsById(id))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account not found.");
		}
		transaction.setDateOfTransaction(new Date());
		Account account = accountRepo.findById(id).get();
		account.getTransaction().add(transaction);

		if (transaction.getTransactionType() == TransactionType.DEPOSIT ) {
			account.setBalance(account.getBalance() + transaction.getTransactionAmount());
		} else {
			account.setBalance(account.getBalance() - transaction.getTransactionAmount());
		}

		
		
		accountRepo.save(account);
	

	}

	public List<Transaction> getAllTransactions(Long id) {
		if (!(accountRepo.existsById(id))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account not found.");
		}
		Account account = accountRepo.findById(id).get();
		return account.getTransaction();
	}

	public List<Transaction> getAllTransactionsByType(Long id, TransactionType transactionType) {
		if (!(accountRepo.existsById(id))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account not found.");
		}
		Account account = accountRepo.findById(id).get();
		return account.getTransaction()
					  .stream()
					  .filter(transaction -> transaction.getTransactionType() == transactionType)
					  .toList();
	}

}
