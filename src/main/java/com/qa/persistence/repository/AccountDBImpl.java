package com.qa.persistence.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;

@Transactional(value = TxType.SUPPORTS)
public class AccountDBImpl {
	Gson gson = new Gson();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public List<Account> getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a", Account.class);
		return query.getResultList();		
	}
	
	public Account findAnAccount(Long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public Account createAnAccount(String account) {
		Account newAccount = gson.fromJson(account, Account.class);
		em.persist(account);
		return newAccount;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public Account updateAnAccount(Long id, String account) {
		Account newAccount = gson.fromJson(account, Account.class);
		TypedQuery<Account> query = em.createQuery("UPDATE Account a "
				+ "SET a = newAccount "
				+ "WHERE a.accountId = id", Account.class);		
		return newAccount;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(Long id) {
		
		em.remove(em.find(Account.class, id));
		return "delete success";
	}
	
	
}
