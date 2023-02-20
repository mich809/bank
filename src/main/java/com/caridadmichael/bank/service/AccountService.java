package com.caridadmichael.bank.service;

import org.springframework.stereotype.Service;

import com.caridadmichael.bank.repository.AccountRepo;

@Service
public class AccountService {
	private final AccountRepo accountRepo;
	
	public AccountService(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	public void getAccount() {
		// TODO Auto-generated method stub
		
	}

}
