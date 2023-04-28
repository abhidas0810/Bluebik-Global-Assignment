package com.bankApp.service;

import java.util.List;

import com.bankApp.entity.User;
import com.bankApp.exception.AccountException;
import com.bankApp.exception.UserException;

public interface UserService {

	public User registerUser(Integer accountNumber, User user) throws UserException, AccountException;

	public User updateUser(User user) throws UserException;

	public User deleteUser(String userEmailId) throws UserException;

	public User getUser(String userEmailId) throws UserException;

	public List<User> getAllUser(Integer accountNumber) throws UserException, AccountException;

}
