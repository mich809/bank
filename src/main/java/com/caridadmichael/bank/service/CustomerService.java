package com.caridadmichael.bank.service;

import java.util.Date;
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

	private final CustomerDTOMapper customerDTOMapper;

	public CustomerService(CustomerRepo customerRepo, CustomerDTOMapper customerDTOMapper) {
		this.customerRepo = customerRepo;
		this.customerDTOMapper = customerDTOMapper;
	}

	public void addCustomer(Customer customer) {	
		customer.setCreationDate(new Date());
		customerRepo.save(customer);

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
