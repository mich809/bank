package com.caridadmichael.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caridadmichael.bank.model.Customer;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		logger.info(String.format("Account created for: %s %s ", customer.getFirstName(), customer.getLastName()));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
