package com.rest.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.User;
import com.rest.repository.IUserRegRepository;
@Service
public class UserRegServiceImpl implements IUserRegService {
	@Autowired
	private IUserRegRepository userrepo;
	@Override
	public User saveUser(User uobj) throws UserAlreadyExistsException {
		Optional<User> suse=this.userrepo.findByEmailId(uobj.getEmail());
		User newuser=null;
		if(suse.isPresent()) {
			throw new UserAlreadyExistsException();
		}else {
			newuser=this.userrepo.save(uobj);
		}
		return newuser;
	}

	@Override
	public User updateUser(User uobj,String email) throws UserNotFoundException {
		Optional<User> upnew=this.userrepo.findByEmailId(email);
		User newuser=null;
		User nuse=null;
		if(upnew.isPresent()) {
			newuser=upnew.get();
			newuser.setUserName(uobj.getUserName());
			newuser.setPassword(uobj.getPassword());
			newuser.setEmail(uobj.getEmail());
			nuse=this.userrepo.save(uobj);
		}else {
			throw new UserNotFoundException();
		}
		return nuse;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		Optional<User> getuser=this.userrepo.findByEmailId(email);
		User display=null;
		if(getuser.isPresent())
		{
			display=getuser.get();
		}else {
			System.out.println("user not exist");
			throw new UserNotFoundException();
		}
		return display;
	}

	@Override
	public List<User> getAllUsers() {
		return this.userrepo.findAll();
	}

	@Override
	public boolean delUser(String email) throws UserNotFoundException {
		Optional<User> del=this.userrepo.findByEmailId(email);
		boolean status=false;
		if(del.isPresent()) {
			this.userrepo.delete(del.get());
			status=true;
		}else {
			System.out.println("user not exists");
			throw new UserNotFoundException();
		}
		return false;
	}
}
