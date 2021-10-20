package com.spring.mongodb.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.api.controller.EkartRepository;
import com.spring.mongodb.api.model.User;

@RestController
@RequestMapping("/order-service")
public class EkartOMController {

	@Autowired
	private EkartRepository ekartRepository;
	
	@RequestMapping(value = "/placeOrderNow", method = RequestMethod.POST)
	public String placeOrder(@RequestBody User user) {
		ekartRepository.save(user);
		return "Order placed successfully...";
	}
	
	@GetMapping("/getUserByName/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return ekartRepository.findByName(name);
	}
	
	@GetMapping("/getUserByAddress/{city}")
	public List<User> getUserByAddress(@PathVariable String city) {
		return ekartRepository.findByCity(city);
	}
	
}
