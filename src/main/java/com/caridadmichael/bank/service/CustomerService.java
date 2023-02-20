package com.caridadmichael.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.caridadmichael.bank.DTO.CustomerDTO;
import com.caridadmichael.bank.DTO.CustomerDTOMapper;
import com.caridadmichael.bank.model.Account;
import com.caridadmichael.bank.model.Customer;
import com.caridadmichael.bank.repository.AccountRepo;
import com.caridadmichael.bank.repository.CustomerRepo;

@Service
public class CustomerService {
	private final CustomerRepo customerRepo;
	private final AccountRepo accountRepo;

	private final CustomerDTOMapper customerDTOMapper;

	public CustomerService(CustomerRepo customerRepo,AccountRepo accountRepo, CustomerDTOMapper customerDTOMapper) {
		this.customerRepo = customerRepo;
		this.accountRepo = accountRepo;
		this.customerDTOMapper = customerDTOMapper;
	}

	public void addCustomer(Customer customer) {
//		Account account = new Account();
//		account.setActive(true);
//		account.setCustomer(customer);
//		customer.setAccount(account);		
		customerRepo.save(customer);
//		accountRepo.save(account);
		
		

	}

	public CustomerDTO getCustomer(Long id) {
		return customerRepo.findById(id).map(customerDTOMapper)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	public void deleteCustomer(Long id) {
		if (!customerRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
		}
		customerRepo.deleteById(id);

	}

	public void updateCustomer(Customer customer, Long id) {
		if (!customerRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
		}
		
		customerRepo.save(customer);

	}

	public List<CustomerDTO> getAllCustomers() {
		return customerRepo.findAll().stream().map(customerDTOMapper).collect(Collectors.toList());

	}

}
