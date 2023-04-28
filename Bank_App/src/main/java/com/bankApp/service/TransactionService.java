package com.bankApp.service;

import com.bankApp.exception.AccountException;
import com.bankApp.exception.UserException;

public interface TransactionService {

	public Double creditAccountBalance(String userEmailId, Double amount)
			throws UserException, AccountException, Exception;

	public Double debitAccountBalance(String userEmailId, Double amount)
			throws UserException, AccountException, Exception;

}
