package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.feign.ItemConsumer;
import com.rest.model.Items;

@RestController
@RequestMapping("/order/path")
public class OrderConsumerController {
	@Autowired
	private ItemConsumer consume;
	@PostMapping("/additem")
	public Items saveItem(@RequestBody Items iobj) {
		return this.consume.saveItemHandler(iobj);
	}
	@GetMapping("/getitems/{productId}")
	public Items getItemById(@PathVariable int productId) {
		return this.consume.getItemByIdHandler(productId);
	}
	@GetMapping("/getAllitems")
	public List<Items> getAllItems() {
		System.out.println("hello");
		return this.consume.getAllitemsHandler();
	}
	@PutMapping("/updateuser/{productId}")
	public Items updateItemById(@RequestBody Items iobj, @PathVariable int productId) {
		return this.updateItemById(iobj, productId);
	}
	@DeleteMapping("/delete/{productId}")
	public boolean delItems(@PathVariable int productId) {
		return this.consume.deleteByHandler(productId);
	}
}
