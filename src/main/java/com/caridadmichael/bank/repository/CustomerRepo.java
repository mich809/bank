package com.caridadmichael.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.caridadmichael.bank.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>, ListCrudRepository<Customer, Long> {

}
