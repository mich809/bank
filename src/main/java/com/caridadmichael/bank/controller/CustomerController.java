package com.caridadmichael.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caridadmichael.bank.DTO.CustomerDTO;
import com.caridadmichael.bank.DTO.LoginRequest;
import com.caridadmichael.bank.model.Customer;
import com.caridadmichael.bank.service.CustomerService;
import com.caridadmichael.bank.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private final CustomerService customerService;
	private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;


	public CustomerController(CustomerService customerService, TokenService tokenService, AuthenticationManager authenticationManager) {
		this.customerService = customerService;
		this.tokenService = tokenService;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/createCustomer")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCustomer(@RequestBody  Customer customer) {
		logger.info(String.format("Account created for: %s ", customer.getUsername()));
		customerService.addCustomer(customer);
	}
	
	

	@GetMapping("/{id}")
	public CustomerDTO getCustomerByID(@PathVariable Long id) {
		logger.info(String.format("fetching account with id:%s ", id));
		return customerService.getCustomer(id);

	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Customer customer, @PathVariable Long id) {
		logger.info(String.format("fetching account with id:%s ", id));
	    customerService.updateCustomer(customer, id);

    }

	@GetMapping()
	public List<CustomerDTO> getAllCustomer() {
		logger.info(String.format("fetching all customers"));
		return customerService.getAllCustomers();

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)	
	public void deleteCustomer(@PathVariable Long id) {
		logger.info(String.format("deleting account with id:%s ", id));
		customerService.deleteCustomer(id);

	}
	
	@PostMapping("/token")
    public String token(@RequestBody LoginRequest loginRequest) throws AuthenticationException  {
      logger.info("Token requested for user: '{}'",loginRequest.username());      
      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
      return tokenService.generateToken(authentication);
    }

}
