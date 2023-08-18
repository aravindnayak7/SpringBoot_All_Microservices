package com.admin.controller;

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

import com.admin.feign.ItemConsumer;
import com.admin.model.Items;

@RestController
@CrossOrigin
@RequestMapping("/admin/path")
public class AdminConsumerController {
 @Autowired
 private ItemConsumer itmconsume;
 @PostMapping("/additem")
 public Items saveItem(@RequestBody Items iobj){
	 return this.itmconsume.saveItemHandler(iobj);
 }
 @GetMapping("/getitems/{productId}")
 public Items getItemById(@PathVariable int productId) {
	 return this.itmconsume.getItemByIdHandler(productId);
 }
 @GetMapping("/getAllitems")
 public List<Items> getAllItems() {
	 return this.itmconsume.getAllitemsHandler();
 }
 @PutMapping("/updateuser/{productId}")
 public Items updateItemById(@RequestBody Items iobj, @PathVariable int productId) {
	 return this.itmconsume.updateItemHandler(iobj, productId);
 }
 @DeleteMapping("/delete/{productId}")
 public boolean delItems(@PathVariable int productId) {
	 return this.itmconsume.deleteByHandler(productId);
 }
}
