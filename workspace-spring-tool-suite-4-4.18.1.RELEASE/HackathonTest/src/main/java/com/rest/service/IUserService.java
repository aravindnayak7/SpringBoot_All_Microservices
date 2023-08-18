package com.rest.service;

import java.util.List;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.User;

public interface IUserService {
	public User saveUser(User uobj)throws UserAlreadyExistsException;
	public User updateUser(User uobj,int uid)throws UserNotFoundException;
	public User getUserById(int uid)throws UserNotFoundException;
	public List<User> getAllUsers();
	public boolean delUser(int uid)throws UserNotFoundException; 
	public boolean validateUser(String username,String password)throws UserNotFoundException;
	
}

