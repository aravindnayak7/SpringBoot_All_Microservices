package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.feign.OrderItemConsumer;
import com.rest.model.Items;

@RestController
@RequestMapping("/orders/v2")
@CrossOrigin
public class OrderConsumerController {
	@Autowired
	private OrderItemConsumer consume;
	@PostMapping("/additem")
	public Items saveItem(@RequestBody Items iobj) {
		return this.consume.saveItemHandler(iobj);
	}
	@GetMapping("/getitems/{productId}")//working
	public Items getItemById(@PathVariable int productId) {
		return this.consume.getItemByIdHandler(productId);
	}
	@GetMapping("/getAllitems")//working
	 public List<Items> getAllItems() {
		 return this.consume.getAllitemsHandler();
	 }
	@PutMapping("/updateuser/{productId}")//working
	 public Items updateItemById(@RequestBody Items iobj, @PathVariable int productId) {
		 return this.consume.updateItemHandler(iobj, productId);
	 }
	@DeleteMapping("/delete/{productId}")//working
	public boolean delItems(@PathVariable int productId) {
		return this.consume.deleteByHandler(productId);
	}
	
}
