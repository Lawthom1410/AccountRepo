package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {
	
	private AccountMapRepository amr = new AccountMapRepository();
	Gson gson = new Gson();
	Account account = new Account(1, 123, "Jack", "Lawthom");
	String accountJson = gson.toJson(account);
	
	Account accUpdate = new Account(1, 123, "James", "Lawthom");
	String accUpdateJson = gson.toJson(accUpdate);
	
	Account acc2 = new Account(2, 124, "Jack", "Jackson");
	Account acc3 = new Account(3, 125, "Bob", "Bobson");
	
	String acc2Json = gson.toJson(acc2);
	String acc3Json = gson.toJson(acc3);

	@Before
	public void setup() {
	}
	
	@Test
	public void addAccountTest() {
		assertEquals("Failed", "Success", amr.createAccount(accountJson));
	}
	
	@Test
	public void updateAccountTest() {
		amr.createAccount(accountJson);
		assertEquals("Failed", "Success", amr.updateAccount(1, accUpdateJson));
		
	}
	
	@Test
	public void dontUpdateAccountThatDoesntExist() {
		assertEquals("Update Test Failed", "Update Failed", amr.updateAccount(1, accUpdateJson));
	}

	@Test
	public void removeAccountTest() {
		amr.createAccount(accountJson);
		assertEquals("Delete Test Failed", "Delete Success", amr.deleteAccount(1));
		
	}
	
	@Test
	public void searchByFirstNameTest() {
		amr.createAccount(accountJson);
		amr.createAccount(acc2Json);
		String jackAccounts = amr.getAllAccounts();
		amr.createAccount(acc3Json);
		
		assertEquals("Search Failed", jackAccounts, amr.searchByFirstName("Jack"));
		
					
	}
	
//	@Test
//	public void remove2AccountsTest() {
//		fail("TODO");	
//	}
//	
//	@Test
//	public void remove2AccountTestAnd1ThatDoesntExist() {
//		fail("TODO");	
//	}
//	
//	@Test
//	public void jsonStringToAccountConversionTest() {
//		// testing JSONUtil
//		fail("TODO");	
//	}
//
//
//	@Test
//	public void accountConversionToJSONTest() {
//		//testing JSONUtil
//		fail("TODO");	
//	}
//
//	@Test
//	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
//		//For a later piece of functionality
//		fail("TODO");	
//	}
//	
//	@Test
//	public void getCountForFirstNamesInAccountWhenOne() {
//		//For a later piece of functionality
//		fail("TODO");	
//	}
//
//	@Test
//	public void getCountForFirstNamesInAccountWhenTwo() {
//		//For a later piece of functionality
//		fail("TODO");	
//	}

}
