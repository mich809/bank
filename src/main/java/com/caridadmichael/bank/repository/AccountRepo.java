package com.caridadmichael.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caridadmichael.bank.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{

}
