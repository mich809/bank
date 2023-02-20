package com.caridadmichael.bank.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int balance = 0;
	private boolean active;	

	@OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Transaction> transactions;

	public Account() {
	};

	public Account(int balance, boolean active, List<Transaction> transactions) {
		this.balance = balance;
		this.active = active;		
		this.transactions = transactions;
	}

	public int getOpeningBalance() {
		return balance;
	}

	public void setOpeningBalance(int balance) {
		this.balance = balance;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}	

	public void setTransactions(List<Transaction> transaction) {
		this.transactions = transaction;
	}

	public List<Transaction> getTransaction() {
		return this.transactions;
	}
}
