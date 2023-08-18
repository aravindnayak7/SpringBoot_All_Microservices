package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.repository.IUserRepository;
@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userrepository;
	@Override
	public User saveUser(User uobj) {
		// TODO Auto-generated method stub
		User adduobj=null;
		Optional<User> optional=this.userrepository.findById(uobj.getUserId());
		if(optional.isPresent()) {
			System.out.println("data is presemt");
		}else{
			adduobj=this.userrepository.save(uobj);
		}
		//otherwise add the data
		//JPA inheriting the crud repository
//		User adduobj=this.userrepository.save(uobj);
		return adduobj;
	}

	@Override
	public User updateUser(User uobj, int uid) {
		// TODO Auto-generated method stub
//		Optional<User> updateuser=this.userrepository.
		Optional<User> userOptional=this.userrepository.findById(uid);// here i will extract the data and save in userOptional
		//i have created two variables uObj and updateData
		User uObj=null;
		User updateData=null;
		if(userOptional.isPresent()) {
			System.out.println("Record exists and ready for update");
			uObj=userOptional.get();  //whatever the record i have i'm fetching to user obj
			uObj.setUserName(uObj.getUserName());
			uObj.setPassword(uObj.getPassword());
			updateData=this.userrepository.save(uObj);
		}
		return updateData;
	}

	@Override
	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		Optional<User> userOptional=this.userrepository.findById(uid);
		User uObj=null;
		if(userOptional.isPresent()) {
			System.out.println("Data is exists");
			uObj=userOptional.get();
		}else {
			System.out.println("data is not present");
		}
		return uObj;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userrepository.findAll();
	}

	@Override
	public boolean delUser(int uid) {
		Optional<User> userOptional=this.userrepository.findById(uid);
		boolean status=false;
		if(userOptional.isPresent()) {
			System.out.println("Record exists and ready to delete");
			this.userrepository.delete(userOptional.get());
			status=true;
		}else {
			System.out.println("Record doesnot exists");
		}
		return status;
	}

}
