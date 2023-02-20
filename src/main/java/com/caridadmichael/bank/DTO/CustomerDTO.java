package com.caridadmichael.bank.DTO;

import com.caridadmichael.bank.model.Account;

public record CustomerDTO(Long id, String firstName, String middleName, String lastName, String city, String telephone,
		String occupation , Account account) {

}
