package com.caridadmichael.bank.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.caridadmichael.bank.model.Account;
import com.caridadmichael.bank.model.AccountType;
import com.caridadmichael.bank.model.Customer;
import com.caridadmichael.bank.repository.AccountRepo;
import com.caridadmichael.bank.repository.CustomerRepo;

@Service
public class AccountService {
	private final AccountRepo accountRepo;
	private final CustomerRepo customerRepo;
	
	public AccountService(AccountRepo accountRepo , CustomerRepo customerRepo) {
		this.accountRepo = accountRepo;
		this.customerRepo = customerRepo;
	}

	public void createAccount(Long id,Account account) {
		if (!(customerRepo.existsById(id))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
		}		
		Customer customer = customerRepo.findById(id).get();
		customer.getAccount().add(account);
		customerRepo.save(customer);
	   
	}

}
