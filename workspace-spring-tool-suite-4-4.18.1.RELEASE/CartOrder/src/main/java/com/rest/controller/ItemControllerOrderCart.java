package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.exception.ItemFoundException;
import com.rest.exception.ItemNotFoundException;
import com.rest.model.Items;
import com.rest.service.ItemServiceImpl;

@Controller
@RequestMapping("cart/order")
@CrossOrigin
public class ItemControllerOrderCart {
	@Autowired
	private ItemServiceImpl itemservice;
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/additem")
	public ResponseEntity<?> saveHanlder(@RequestBody Items iobj)throws ItemFoundException{
		Items additem=null;
		try {
			additem=this.itemservice.saveItem(iobj);
			 responseEntity=new ResponseEntity<>(additem,HttpStatus.CREATED);
		}catch(ItemFoundException e) {
			responseEntity=new ResponseEntity<>(additem,HttpStatus.CONFLICT);
			throw new ItemFoundException();
		}
		return responseEntity;
	}
	@GetMapping("/getitems/{productId}")
	public ResponseEntity<?> updateHanlder(@PathVariable int productId)throws ItemNotFoundException{
		Items getitemsss=null;
		try {
			getitemsss=this.itemservice.getItemById(productId);
			responseEntity=new ResponseEntity<>(getitemsss,HttpStatus.OK);
		}catch(ItemNotFoundException e) {
			throw new ItemNotFoundException();
		}
		responseEntity=new ResponseEntity<>(getitemsss,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/getAllitems")
	public ResponseEntity<?> getAllItemsHandler(){
		List<Items> allitems=null;
		try {
			allitems=this.itemservice.getAllItems();
			responseEntity=new ResponseEntity<>(allitems,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	@PutMapping("/updateinfo/{productId}")
	public ResponseEntity<?> updateByIdHandler(@RequestBody Items iobj,@PathVariable int productId)throws ItemNotFoundException{
		Items updateitem=null;
		try {
			updateitem=this.itemservice.updateItemsById(iobj, productId);
			responseEntity=new ResponseEntity<>(updateitem,HttpStatus.CREATED);
		}catch(ItemNotFoundException e) {
			throw new ItemNotFoundException();
		}
		return responseEntity;
	}
	@DeleteMapping("/delitem/{productId}")
	public ResponseEntity<?> delItemHandler(@PathVariable int productId)throws ItemNotFoundException{
		boolean status=true;
		try {
			this.itemservice.delItems(productId);
			responseEntity=new ResponseEntity<>(HttpStatus.OK);
		}catch(ItemNotFoundException e) {
			throw new ItemNotFoundException();
		}
		return responseEntity;
	}
}
