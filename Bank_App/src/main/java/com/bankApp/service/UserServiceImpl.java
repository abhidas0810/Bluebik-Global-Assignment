package com.bankApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApp.entity.Account;
import com.bankApp.entity.User;
import com.bankApp.exception.AccountException;
import com.bankApp.exception.UserException;
import com.bankApp.repository.AccountRepository;
import com.bankApp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(Integer accountNumber, User user) throws UserException, AccountException {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(() -> new AccountException("Account not found with AccountNumber: " + accountNumber));
		Optional<User> userOptional = userRepository.findById(user.getUserEmailId());
		if (userOptional.isPresent()) {
			throw new UserException("User already exists with UserEmailId: " + user.getUserEmailId());
		}
		account.getUsers().add(user);
		user.setAccount(account);
		accountRepository.save(account);
		return user;
	}

	@Override
	public User updateUser(User user) throws UserException {
		User registeredUser = userRepository.findById(user.getUserEmailId()).orElseThrow(
				() -> new UserException("User does not exists with UserEmailId: " + user.getUserEmailId()));
		registeredUser.setName(user.getName());
		return userRepository.save(registeredUser);
	}

	@Override
	public User deleteUser(String userEmailId) throws UserException {
		User user = userRepository.findById(userEmailId)
				.orElseThrow(() -> new UserException("User does not exists with UserEmailId: " + userEmailId));
		userRepository.delete(user);
		return user;
	}

	@Override
	public User getUser(String userEmailId) throws UserException {
		return userRepository.findById(userEmailId)
				.orElseThrow(() -> new UserException("User does not exists with UserEmailId: " + userEmailId));
	}

	@Override
	public List<User> getAllUser(Integer accountNumber) throws UserException, AccountException {
		List<User> users = accountRepository.findById(accountNumber)
				.orElseThrow(() -> new AccountException("Account not found with AccountNumber: " + accountNumber))
				.getUsers();
		if (users.isEmpty()) {
			throw new UserException("No user found.");
		}
		return users;
	}

}
