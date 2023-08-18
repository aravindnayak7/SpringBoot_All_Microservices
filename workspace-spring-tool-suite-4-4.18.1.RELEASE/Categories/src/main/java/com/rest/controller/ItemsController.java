package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.exception.ItemFoundException;
import com.rest.exception.ItemNotFoundException;
import com.rest.model.Items;
import com.rest.service.ItemsServiceImpl;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class ItemsController {
@Autowired
private ItemsServiceImpl iservice;
private ResponseEntity<?> response;
@PostMapping("/additem")//working
public ResponseEntity<?> saveItemHanlder(@RequestBody Items iobj)throws ItemFoundException{
	Items additem=null;
	try {
		additem=this.iservice.saveItem(iobj);
		response=new ResponseEntity<>(additem,HttpStatus.CREATED);
	}catch(Exception e) {
		response=new ResponseEntity<>(additem,HttpStatus.NOT_FOUND);
		throw new ItemFoundException();
	}
	return response;
}
@GetMapping("/getitems/{productId}")//working
public ResponseEntity<?> getItemByIdHandler(@PathVariable int productId)throws ItemNotFoundException{
	Items getitm=null;
	try {
		getitm=this.iservice.getItemById(productId);
		response=new ResponseEntity<>(getitm,HttpStatus.OK);
	}catch(Exception e) {
		response=new ResponseEntity<>(getitm,HttpStatus.NOT_FOUND);
		throw new ItemNotFoundException();
	}
	return response;
}
@GetMapping("/getAllitems")//working
public ResponseEntity<?> getAllitemsHandler(){
	List<Items> getallitms=null;
	try {
		getallitms=this.iservice.getAllItems();
		response=new ResponseEntity<>(getallitms,HttpStatus.OK);
	}catch(Exception e) {
		response=new ResponseEntity<>(getallitms,HttpStatus.NOT_FOUND);
	}
	return response;
}
@PutMapping("/updateuser/{productId}")//working
	public ResponseEntity<?> updateItemHandler(@RequestBody Items iobj, @PathVariable int productId)throws ItemFoundException{
	Items upitem=null;
	try {
		upitem=this.iservice.updateItemById(iobj, productId);
		response=new ResponseEntity<>(upitem,HttpStatus.CREATED);
	}catch(Exception e) {
		response=new ResponseEntity<>(upitem,HttpStatus.CONFLICT);
		throw new ItemFoundException();
	}
	return response;
}
@DeleteMapping("/delete/{productId}")//working
public ResponseEntity<?> deleteByHandler(@PathVariable int productId)throws ItemNotFoundException{
	boolean del=false;
	try {
		del=this.iservice.delItems(productId);
		response=new ResponseEntity<>(del,HttpStatus.OK);
	}catch(Exception e) {
		response=new ResponseEntity<>(del,HttpStatus.NOT_FOUND);
		throw new ItemNotFoundException();
	}
	return response;
}
@GetMapping("/getcatitems/{category}")
public ResponseEntity<?> getallItemsHandler(@PathVariable String category)throws ItemNotFoundException{
	List<Items> catitem=null;
	try {
		catitem=this.iservice.validateByCategory(category);
		response=new ResponseEntity<>(catitem,HttpStatus.OK);
	}catch(Exception e) {
		response=new ResponseEntity<>(catitem,HttpStatus.NOT_FOUND);
		throw new ItemNotFoundException();
	}
	return response;
}
}
