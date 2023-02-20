package com.caridadmichael.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caridadmichael.bank.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {

}
