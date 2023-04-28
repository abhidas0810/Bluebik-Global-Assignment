package com.bankApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApp.entity.Account;
import com.bankApp.entity.User;
import com.bankApp.exception.AccountException;
import com.bankApp.exception.UserException;
import com.bankApp.repository.AccountRepository;
import com.bankApp.repository.UserRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Double creditAccountBalance(String userEmailId, Double amount)
			throws UserException, AccountException, Exception {
		User user = userRepository.findById(userEmailId)
				.orElseThrow(() -> new UserException("User does not exists with UserEmailId: " + userEmailId));
		Account account = user.getAccount();
		if (account == null) {
			throw new AccountException("User does not have any account.");
		}
		if (account.getBalance() + amount > 10000000.0) {
			throw new Exception("Account can not hold amount more than 10 million balance.");
		}
		account.setBalance(account.getBalance() + amount);
		accountRepository.save(account);
		return account.getBalance();
	}

	@Override
	public Double debitAccountBalance(String userEmailId, Double amount)
			throws UserException, AccountException, Exception {
		User user = userRepository.findById(userEmailId)
				.orElseThrow(() -> new UserException("User does not exists with UserEmailId: " + userEmailId));
		Account account = user.getAccount();
		if (account == null) {
			throw new AccountException("User does not have any account.");
		}
		if (account.getBalance() - amount < 0.0) {
			throw new Exception("Insufficient balance.");
		}
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		return account.getBalance();
	}

}
