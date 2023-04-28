package com.bankApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApp.entity.Account;
import com.bankApp.exception.AccountException;
import com.bankApp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) throws AccountException {
		Optional<Account> accountOptional = accountRepository.findById(account.getAccountNumber());
		if (accountOptional.isPresent()) {
			throw new AccountException("Account already created with AccountNumber: " + account.getAccountNumber());
		}
		if (account.getBalance() < 0.0 || account.getBalance() > 10000000.0) {
			throw new AccountException(
					"Account balance cannot go beyond 10 million and account balance cannot go below 0");
		}
		return accountRepository.save(account);
	}

	@Override
	public Account deleteAccount(Integer accountNumber) throws AccountException {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(() -> new AccountException("Account not found with AccountNumber: " + accountNumber));
		accountRepository.delete(account);
		return account;
	}

	@Override
	public Account getAccount(Integer accountNumber) throws AccountException {
		return accountRepository.findById(accountNumber)
				.orElseThrow(() -> new AccountException("Account not found with AccountNumber: " + accountNumber));
	}

	@Override
	public List<Account> getAllAccount() throws AccountException {
		List<Account> accounts = accountRepository.findAll();
		if (accounts.isEmpty()) {
			throw new AccountException("No account found.");
		}
		return accounts;
	}

}
