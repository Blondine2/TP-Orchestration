package com.eshop.ms.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.eshop.ms.model.User;

@Component
public class UserRepository {

	private Map<String, User> userInMemory = new HashMap<>();
	
	public void addUser(User user){
		System.out.println("AddUser : username " + user.getUsername());
		
		userInMemory.put(user.getUsername(), user);
	}
	
	public User getUserByUsername(String username){
		System.out.println("getting User By his username : " + username);
		return userInMemory.get(username);
	}
	
	public List<User> getAll(){
		return new ArrayList<User>(userInMemory.values());
	}
	
	public void updateUser(User user){
		System.out.println("updating the user named " + user.getUsername());
		userInMemory.put(user.getUsername(), user);
	}
	
	public void deleteUserByUsername(String username){
		System.out.println("deleting the user named : " + username);
		userInMemory.remove(username);
	}
}
