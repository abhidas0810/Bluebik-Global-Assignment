package com.bankApp.service;

import java.util.List;

import com.bankApp.entity.Account;
import com.bankApp.exception.AccountException;

public interface AccountService {

	public Account createAccount(Account account) throws AccountException;
	
	public Account deleteAccount(Integer accountNumber) throws AccountException;
	
	public Account getAccount(Integer accountNumber) throws AccountException;
	
	public List<Account> getAllAccount() throws AccountException;
	
}
