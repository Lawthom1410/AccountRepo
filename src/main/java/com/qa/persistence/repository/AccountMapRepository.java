package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;

public class AccountMapRepository implements AccountRepository{
	
	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
	Gson gson = new Gson();
	
	//You must provide concrete implementation for each of these methods
	//do not change the method signature
	//THINK - if the parameter is a String, or the return type is a String
	//How can I convert to a String from an Object?
	//What utility methods do I have available?
	
	//You must complete this section using TDD
	//You can use the suggested tests or build your own.

	public String getAllAccounts() {
		// TODO Auto-generated method stub		
		return gson.toJson(accountMap);
	}

	public String createAccount(String accountStr) {
		// TODO Auto-generated method stub
		Account account = gson.fromJson(accountStr, Account.class);
		this.accountMap.put(account.getAccountId(), account);
		if (accountMap.containsValue(account)) {
			return "Success";
		} else {
			return null;
		}
	}

	public String deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		this.accountMap.remove(accountId);
		if (accountMap.containsKey(accountId)) {
			return null;
		} else {
			return "Delete Success";
		}
	}

	public String updateAccount(int accountId, String accountStr) {
		// TODO Auto-generated method stub
		Account account = gson.fromJson(accountStr, Account.class);
		this.accountMap.replace(accountId, account);
		if (accountMap.containsValue(account)) {
			return "Success";
		} else {
			return "Update Failed";			
		}
	}
	
	public String searchByFirstName(String name) {
		Map<Integer, Account> toReturnMap = this.accountMap.values().stream().filter(x -> name.equals(x.getFirstName())).collect(Collectors.toMap(m -> m.getAccountId(), m -> m));
		System.out.println(toReturnMap.size());
		return gson.toJson(toReturnMap);
	}
}
