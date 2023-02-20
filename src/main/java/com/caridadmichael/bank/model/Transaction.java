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

	@CreatedDate
	private Date dateOfTransaction;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId")
	private Account account;

	public Transaction() {
	}

	public Transaction(Date dateOfTransaction, String typeOfTransaction, int transactionAmount, Account account) {
		this.dateOfTransaction = dateOfTransaction;
		this.typeOfTransaction = typeOfTransaction;
		this.transactionAmount = transactionAmount;
		this.account = account;
	}

	private String typeOfTransaction;
	private int transactionAmount;

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
