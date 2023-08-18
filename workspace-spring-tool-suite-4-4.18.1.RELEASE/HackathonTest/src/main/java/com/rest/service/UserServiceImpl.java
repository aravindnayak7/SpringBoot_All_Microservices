package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.User;
import com.rest.repository.IUserRepository;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userrepo;
	@Override
	public User saveUser(User uobj) throws UserAlreadyExistsException {
		Optional<User> suse=this.userrepo.findById(uobj.getUid());
		User newuser=null;
		if(suse.isPresent()) {
			throw new UserAlreadyExistsException();
		}else {
			
			newuser=this.userrepo.save(uobj);
		}
		return newuser;
	}

	@Override
	public User updateUser(User uobj, int uid) throws UserNotFoundException {
		Optional<User> upnew=this.userrepo.findById(uid);
		User newuser=null;
		if(upnew.isPresent()) {
			newuser.setUid(uobj.getUid());
			newuser.setUsername(uobj.getUsername());
			newuser.setEmail(uobj.getEmail());
			newuser.setPassword(uobj.getPassword());
			newuser=this.userrepo.save(uobj);
		}else {
			System.out.println("user already exists");
			throw new UserNotFoundException();
		}
		return newuser;
	}

	@Override
	public User getUserById(int uid) throws UserNotFoundException {
		Optional<User> getuser=this.userrepo.findById(uid);
		User display=null;
		if(getuser.isPresent()) {
			display=getuser.get();
		}else {
			System.out.println("user not found");
			throw new UserNotFoundException();
		}
		return display;
	}

	@Override
	public List<User> getAllUsers() {
		return this.userrepo.findAll();
	}

	@Override
	public boolean delUser(int uid) throws UserNotFoundException {
		Optional<User> del=this.userrepo.findById(uid);
		boolean status=false;
		if(del.isPresent()) {
			this.userrepo.delete(del.get());
		}else {
			System.out.println("data is not present");
		}
		return true;
	}

	@Override
	public boolean validateUser(String username, String password) throws UserNotFoundException {
		User user=this.userrepo.validateUser(username,password);
		System.out.println("username"+user);
		if(user != null) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
