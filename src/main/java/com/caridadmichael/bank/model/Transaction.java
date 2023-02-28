package com.caridadmichael.bank.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Transaction {

	@Id
	@SequenceGenerator(name = "transaction_id_sequence", sequenceName = "transaction_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_sequence")
	private Long id;
	
	private TransactionType transactionType;
	
	private int transactionAmount;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfTransaction;

	
	
	

	public Transaction() {
	}

	public Transaction(Date dateOfTransaction, TransactionType transactionType, int transactionAmount) {
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.setTransactionAmount(transactionAmount);
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


	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
