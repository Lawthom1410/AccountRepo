package com.qa.persistence.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistence.domain.Account;

public class App {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		Account account = new Account(1, 123, "Jack", "Lawthom");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(account);
		System.out.println(json);
	}

}
