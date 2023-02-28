package com.caridadmichael.bank.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Account {

	@Id
	@SequenceGenerator(name = "account_id_sequence", sequenceName = "account_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_sequence")
	private Long id;
	private int balance = 0;
	private boolean active;	
	private AccountType accountType;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	List<Transaction> transactions;

	public Account() {
	};

	public Account(int balance, boolean active, List<Transaction> transactions, AccountType accountType) {
		this.balance = balance;
		this.active = active;		
		this.transactions = transactions;
		this.setAccountType(accountType);
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}	

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Transaction> getTransaction() {
		return this.transactions;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
