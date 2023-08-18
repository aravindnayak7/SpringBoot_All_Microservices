package com.rest.service;

import java.util.List;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.User;

public interface IUserRegService {
	public User saveUser(User uobj)throws UserAlreadyExistsException;
	public User updateUser(User uobj,String email)throws UserNotFoundException;
	public User getUserByEmail(String email)throws UserNotFoundException;
	public List<User> getAllUsers();
	public boolean delUser(String email)throws UserNotFoundException; 
}
