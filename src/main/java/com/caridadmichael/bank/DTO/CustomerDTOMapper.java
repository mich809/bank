package com.caridadmichael.bank.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.caridadmichael.bank.model.Customer;

@Service
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {

	@Override
	public CustomerDTO apply(Customer customer) {
		return new CustomerDTO(customer.getFirstName(), customer.getMiddleName(), customer.getLastName(),
				customer.getCity(), customer.getTelephone(), customer.getOccupation());
	}

}
