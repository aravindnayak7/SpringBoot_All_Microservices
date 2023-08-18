package com.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest.model.User;

@FeignClient(name="register-service", url="http://localhost:8080/api/v1")
public interface IRegConsumer {
	@GetMapping("/getuserbyid/{email}")
	public User getUserByIdHandler(@PathVariable String email);

}
