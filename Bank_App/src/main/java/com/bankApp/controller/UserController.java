package com.bankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankApp.entity.User;
import com.bankApp.exception.AccountException;
import com.bankApp.exception.UserException;
import com.bankApp.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/{accountNumber}")
	public ResponseEntity<User> registerUser(@PathVariable Integer accountNumber, @Valid @RequestBody User user)
			throws UserException, AccountException {
		return new ResponseEntity<User>(userService.registerUser(accountNumber, user), HttpStatus.CREATED);
	}

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws UserException {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/user/{userEmailId}")
	public ResponseEntity<User> deleteUser(@PathVariable String userEmailId) throws UserException {
		return new ResponseEntity<User>(userService.deleteUser(userEmailId), HttpStatus.OK);
	}

	@GetMapping("/user/{userEmailId}")
	public ResponseEntity<User> getUser(@PathVariable String userEmailId) throws UserException {
		return new ResponseEntity<User>(userService.getUser(userEmailId), HttpStatus.OK);
	}

	@GetMapping("/user/{accountNumber}")
	public ResponseEntity<List<User>> getAllUser(@PathVariable Integer accountNumber)
			throws UserException, AccountException {
		return new ResponseEntity<List<User>>(userService.getAllUser(accountNumber), HttpStatus.OK);
	}

}
