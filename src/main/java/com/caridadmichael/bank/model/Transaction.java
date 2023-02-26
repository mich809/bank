package com.caridadmichael.bank.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private TransactionType transactionType;
	
	private int transactionAmount;

	@CreatedDate
	private Date dateOfTransaction;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId")
	private Account account;
	
	

	public Transaction() {
	}

	public Transaction(Date dateOfTransaction, TransactionType transactionType, int transactionAmount, Account account) {
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransctionAmount() {
		return transactionAmount;
	}

	public void setTransctionAmount(int transctionAmount) {
		this.transactionAmount = transctionAmount;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
