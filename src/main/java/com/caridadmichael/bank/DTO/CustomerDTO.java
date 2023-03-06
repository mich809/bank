package com.caridadmichael.bank.DTO;

import java.util.Date;
import java.util.List;

import com.caridadmichael.bank.model.Account;

public record CustomerDTO(Long id, String username ,String firstName, String middleName, String lastName, String city, String telephone,
		String occupation ,Date creationDate, List<Account> account) {

}
