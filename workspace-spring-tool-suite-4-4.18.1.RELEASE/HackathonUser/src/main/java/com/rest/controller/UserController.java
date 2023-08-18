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
import com.rest.model.User;
import com.rest.service.IUserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private IUserService userservice;
	private ResponseEntity<?> responseEntity;
	 @PostMapping("/adduser")//working
	 public ResponseEntity<?> saveUserHandler(@RequestBody User uobj){
		 User saveuser=null;
		 try {
			 saveuser=this.userservice.saveUser(uobj);
		 }catch(UserAlreadyExistsException e) {
			 e.printStackTrace();
		 }
		 responseEntity=new ResponseEntity<>(saveuser,HttpStatus.CREATED);
		 return responseEntity;
	 }
	 @PutMapping("/updateuser/{uid}")//working
	 public ResponseEntity<?> updateHandler(@RequestBody User uobj,@PathVariable int uid)throws UserNotFoundException{
		 User upuser=this.userservice.updateUser(uobj, uid);
		 responseEntity=new ResponseEntity<>(upuser,HttpStatus.OK);
		 return responseEntity;
	 }
	 @GetMapping("/getuserbyid/{uid}")//working
	 public ResponseEntity<?> getUserByIdHandler(@PathVariable int uid)throws UserNotFoundException{
		 User getuser=this.userservice.getUserByEmail(uid);
		 responseEntity=new ResponseEntity<>(getuser,HttpStatus.OK);
		 return responseEntity;
	 }
	 @GetMapping("/getalluserss")//working
	 public ResponseEntity<?> getAlluserHandler(){
		 List<User> alluser=this.userservice.getAllUsers();
		 responseEntity=new ResponseEntity<>(alluser,HttpStatus.OK);
		 return responseEntity;
	 }
	 @DeleteMapping("/deluser/{uid}")//working
		public ResponseEntity<?> delByHandler(@PathVariable int uid)throws UserNotFoundException{
			boolean status=this.userservice.delUser(uid);
			responseEntity=new ResponseEntity<>(status,HttpStatus.OK);
			return responseEntity;
		}
}
