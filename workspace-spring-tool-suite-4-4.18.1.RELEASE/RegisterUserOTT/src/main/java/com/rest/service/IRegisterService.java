package com.rest.service;

import java.util.List;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.RegisterUser;

public interface IRegisterService {
	public RegisterUser saveUser(RegisterUser user)throws UserAlreadyExistsException;
	public RegisterUser getUserById(String email)throws UserNotFoundException;
	public List<RegisterUser> getAllUsers();
	public boolean deleteUser(String email)throws UserNotFoundException;
	public RegisterUser updateUser(RegisterUser user, String email)throws UserAlreadyExistsException;
	public boolean validateUser(String email,String password)throws UserNotFoundException;
}
