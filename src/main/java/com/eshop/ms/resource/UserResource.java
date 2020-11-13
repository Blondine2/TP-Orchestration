package com.eshop.ms.resource;

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

import com.eshop.ms.model.User;
import com.eshop.ms.service.UserService;

@RestController
@RequestMapping(value = "users", produces = {"application/json"})
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> getAll(){
		return service.getAll();
	}
	
	@GetMapping("{username}")
	public User getOne(@PathVariable("username") String username){
		
		return service.getUser(username);
	}
	
	@PostMapping()
	public void addUser(@RequestBody User user){
		
		service.addUser(user);
	}
	
	@PutMapping("{username}")
	public void updateUser(@PathVariable("username") String username, @RequestBody User user){
		
		service.updateUser(username, user);
	}
	
	@DeleteMapping("{username}")
	public void deleteUser(@PathVariable("username") String username){
		
		service.deleteUser(username);
	}
	
}
