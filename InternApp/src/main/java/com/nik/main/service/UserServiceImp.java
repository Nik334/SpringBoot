package com.nik.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nik.main.dao.UserRepo;
import com.nik.main.model.User;

@RestController
public class UserServiceImp 
{
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/users")
	public List<User> users() {
		return userRepo.findAll();
	}
	
	@GetMapping("user/{userId}")
	public Optional<User> getUser(@PathVariable("userId") long userId) {
		return userRepo.findById(userId);
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}
}
