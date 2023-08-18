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
		Optional<User> suse=this.userrepo.findById(uobj.getBookingId());
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
		User nuse=null;
		if(upnew.isPresent()) {
			newuser=upnew.get();
			newuser.setName(uobj.getName());
			newuser.setAccountnumber(uobj.getAccountnumber());
			newuser.setAddress(uobj.getAddress());
			newuser.setMobileno(uobj.getMobileno());
			newuser.setPassword(uobj.getPassword());
			nuse=this.userrepo.save(uobj);
		}else {
			throw new UserNotFoundException();
		}
		return nuse;
	}

	@Override
	public User getUserByEmail(int uid) throws UserNotFoundException {
		Optional<User> getuser=this.userrepo.findById(uid);
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
	public boolean delUser(int uid) throws UserNotFoundException {
		Optional<User> del=this.userrepo.findById(uid);
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
