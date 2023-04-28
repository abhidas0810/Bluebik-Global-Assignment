package com.bankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankApp.exception.AccountException;
import com.bankApp.exception.UserException;
import com.bankApp.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PutMapping("/credit/{userEmailId}/{amount}")
	public ResponseEntity<Double> creditAccountBalance(String userEmailId, Double amount)
			throws UserException, AccountException, Exception {
		return new ResponseEntity<Double>(transactionService.creditAccountBalance(userEmailId, amount),
				HttpStatus.ACCEPTED);
	}

	@PutMapping("/debit/{userEmailId}/{amount}")
	public ResponseEntity<Double> debitAccountBalance(String userEmailId, Double amount)
			throws UserException, AccountException, Exception {
		return new ResponseEntity<Double>(transactionService.debitAccountBalance(userEmailId, amount),
				HttpStatus.ACCEPTED);
	}

}
