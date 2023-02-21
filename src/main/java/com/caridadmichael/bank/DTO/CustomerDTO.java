package com.caridadmichael.bank.DTO;

import java.util.List;

import com.caridadmichael.bank.model.Account;

public record CustomerDTO(Long id, String firstName, String middleName, String lastName, String city, String telephone,
		String occupation , List<Account> account) {

}
