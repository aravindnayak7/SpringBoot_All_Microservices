package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.feign.IRegConsumer;
import com.rest.model.User;

@Service
public class LoginUserImpl implements ILoginService {
	@Autowired
	private IRegConsumer regconsume;
	@Override
	public boolean validateUser(User uobj) {
		User user=this.regconsume.getUserByIdHandler(uobj.getEmail());
		System.out.println("username"+user);
		if(user != null) {
//			return true;
			if(user.getPassword().equals(uobj.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
		else {
			return false;
		}
	}

}
