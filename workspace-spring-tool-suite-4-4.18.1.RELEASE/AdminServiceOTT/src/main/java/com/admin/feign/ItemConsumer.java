package com.admin.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.admin.model.Items;

@FeignClient(name="item-service", url="http://localhost:8085/api/v1")
public interface ItemConsumer {
	@PostMapping("/additem")
	public Items saveItemHandler(@RequestBody Items iobj);
	
	@GetMapping("/getitems/{productId}")
	public Items getItemByIdHandler(@PathVariable int productId);
	
	@GetMapping("/getAllitems")
	public List<Items> getAllitemsHandler();
	
	@PutMapping("/updateuser/{productId}")
	public Items updateItemHandler(@RequestBody Items iobj, @PathVariable int productId);
	
	@DeleteMapping("/delete/{productId}")
	public boolean deleteByHandler(@PathVariable int productId);
}
