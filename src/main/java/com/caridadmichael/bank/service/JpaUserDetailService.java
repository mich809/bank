package com.caridadmichael.bank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.caridadmichael.bank.controller.CustomerController;
import com.caridadmichael.bank.model.Customer;
import com.caridadmichael.bank.model.SecurityCustomer;
import com.caridadmichael.bank.repository.CustomerRepo;

@Service
public class JpaUserDetailService implements UserDetailsService	 {
	
	private CustomerRepo customerRepo;
	private static final Logger logger = LoggerFactory.getLogger(JpaUserDetailService.class);


	public JpaUserDetailService(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("inside userdetails");
//		Customer customer = customerRepo.findByUserName("michael").get();
//		logger.info("found customer: ", customer.getUsername());

		
		
		return customerRepo
				.findByUsername(username)
				.map(SecurityCustomer::new)
				.orElseThrow(()-> new UsernameNotFoundException("Username not found: " + username));
	}

}
