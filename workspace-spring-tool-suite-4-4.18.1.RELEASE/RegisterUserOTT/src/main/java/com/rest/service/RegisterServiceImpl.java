package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.RegisterUser;
import com.rest.repository.IRegJRepository;
@Service
public class RegisterServiceImpl implements IRegisterService {
	@Autowired
	private IRegJRepository regrepo;
	@Override
	public RegisterUser saveUser(RegisterUser user) throws UserAlreadyExistsException {
		Optional<RegisterUser> saveuser=this.regrepo.findById(user.getEmail());
		RegisterUser newuser=null;
		if(saveuser.isPresent()) {
			throw new UserAlreadyExistsException();
		}else {
			newuser=this.regrepo.save(user);
		}
		return newuser;
	}

	@Override
	public RegisterUser getUserById(String email) throws UserNotFoundException {
		Optional<RegisterUser> getuser=this.regrepo.findById(email);
		RegisterUser display=null;
		if(getuser.isPresent()) {
			display=getuser.get();
		}else {
			throw new UserNotFoundException();
		}
		return display;
	}

	@Override
	public List<RegisterUser> getAllUsers() {
		// TODO Auto-generated method stub
		return this.regrepo.findAll();
	}

	@Override
	public boolean deleteUser(String email) throws UserNotFoundException {
		Optional<RegisterUser> deluser=this.regrepo.findById(email);
		boolean status=false;
		if(deluser.isPresent()) {
			this.regrepo.delete(deluser.get());
		}else {
			throw new UserNotFoundException();
		}
		
		return true;
	}

	@Override
	public RegisterUser updateUser(RegisterUser user, String email) throws UserAlreadyExistsException {
		Optional<RegisterUser> upuser=this.regrepo.findById(email);
		RegisterUser assigninfo=null;
		RegisterUser updatedata=null;
		if(upuser.isPresent()) {
			assigninfo=upuser.get();
			assigninfo.setFirsname(user.getFirsname());
			assigninfo.setLastname(user.getLastname());
			assigninfo.setAge(user.getAge());
			assigninfo.setGender(user.getGender());
			assigninfo.setMobilenum(user.getMobilenum());
			assigninfo.setPassword(user.getPassword());
			updatedata=this.regrepo.save(assigninfo);
		}else {
			throw new UserAlreadyExistsException();
		}
		return updatedata;
	}

	@Override
	public boolean validateUser(String email, String password) throws UserNotFoundException {
		RegisterUser user=this.regrepo.validateUser(email,password);
		System.out.println("user"+ user);
		if(user !=null) {
			return true;
		}else {
			return false;
		}
	}

}
