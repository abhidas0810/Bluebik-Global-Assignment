package com.bankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankApp.entity.Account;
import com.bankApp.exception.AccountException;
import com.bankApp.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) throws AccountException {
		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.CREATED);
	}

	@DeleteMapping("/account/{accountNumber}")
	public ResponseEntity<Account> deleteAccount(@PathVariable Integer accountNumber) throws AccountException {
		return new ResponseEntity<Account>(accountService.deleteAccount(accountNumber), HttpStatus.OK);
	}

	@GetMapping("/account/{accountNumber}")
	public ResponseEntity<Account> getAccount(Integer accountNumber) throws AccountException {
		return new ResponseEntity<Account>(accountService.getAccount(accountNumber), HttpStatus.OK);
	}

	@GetMapping("/account")
	public ResponseEntity<List<Account>> getAllAccount() throws AccountException {
		return new ResponseEntity<List<Account>>(accountService.getAllAccount(), HttpStatus.OK);
	}

}
