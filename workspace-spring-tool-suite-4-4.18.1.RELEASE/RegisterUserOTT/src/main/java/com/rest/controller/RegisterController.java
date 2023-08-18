package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.RegisterUser;
import com.rest.service.IRegisterService;
import com.rest.service.RegisterServiceImpl;

@RestController
@RequestMapping("/api")
public class RegisterController {
	@Autowired
	private IRegisterService regserv;
	private ResponseEntity<?> responseEntity;
	@PostMapping("/adduser")//working
	public ResponseEntity<?> saveUserHandler(@RequestBody RegisterUser user)throws UserAlreadyExistsException{
		RegisterUser newUser=null;
		try {
			newUser=this.regserv.saveUser(user);
			responseEntity=new ResponseEntity<>(newUser,HttpStatus.CREATED);
		}catch(Exception e) {
			responseEntity=new ResponseEntity<>(newUser,HttpStatus.NOT_FOUND);
			throw new UserAlreadyExistsException();
		}
		return responseEntity;
	}
	
	@GetMapping("/getuserbyid/{email}")//working
	public ResponseEntity<?> getUserByIdHandler(@PathVariable String email)throws UserNotFoundException{
		RegisterUser getuser=null;
		try {
			getuser=this.regserv.getUserById(email);
			responseEntity=new ResponseEntity<>(getuser,HttpStatus.OK);
		}catch(Exception e) {
			responseEntity=new ResponseEntity<>(getuser,HttpStatus.NOT_FOUND);
			throw new UserNotFoundException();
		}
		return responseEntity;
	}
	@GetMapping("/getallusers")//working
	public ResponseEntity<?> getAllUsersHandler()throws UserNotFoundException{
		List<RegisterUser> allusers=null;
		try {
			allusers=this.regserv.getAllUsers();
			responseEntity=new ResponseEntity<>(allusers,HttpStatus.OK);
		}catch(Exception e) {
			responseEntity=new ResponseEntity<>(allusers,HttpStatus.NOT_FOUND);
			throw new UserNotFoundException();
		}
		return responseEntity;
	}
	@PutMapping("/updateby/{email}")//working
	public ResponseEntity<?> updateUserByIdHandler(@RequestBody RegisterUser user, @PathVariable String email)throws UserAlreadyExistsException{
		RegisterUser updateuser=null;
		try {
			updateuser=this.regserv.updateUser(user, email);
			responseEntity=new ResponseEntity<>(updateuser,HttpStatus.CREATED);
		}catch(Exception e) {
			responseEntity=new ResponseEntity<>(updateuser,HttpStatus.NOT_FOUND);
		}
		return responseEntity;
 	}
	@DeleteMapping("/deletebyid/{email}")//working
	public ResponseEntity<?> deleteUserByIdHandler(@PathVariable String email)throws UserNotFoundException{
		boolean del=false;
		try {
			del=this.regserv.deleteUser(email);
			responseEntity=new ResponseEntity<>(del,HttpStatus.OK);
		}catch(Exception e) {
			responseEntity=new ResponseEntity<>(del,HttpStatus.NOT_FOUND);
			throw new UserNotFoundException();
		}
		return responseEntity;
	}
	@PostMapping("/authUser")
	public ResponseEntity<?> validateUserHandler(@RequestBody RegisterUser user)throws UserNotFoundException{
		boolean r =false;
		try {
		r = this.regserv.validateUser(user.getEmail(), user.getPassword());
		if(r)
		responseEntity = new ResponseEntity<>(r,HttpStatus.OK);
		else
			responseEntity = new ResponseEntity<>(r,HttpStatus.UNAUTHORIZED);
		}catch(Exception e) {
			responseEntity = new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
			throw new UserNotFoundException();
		}
		return responseEntity;
	}
}
