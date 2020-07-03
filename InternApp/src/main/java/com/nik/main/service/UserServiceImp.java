package com.nik.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nik.main.dao.UserRepo;
import com.nik.main.model.Job;
import com.nik.main.model.User;

@RestController
public class UserServiceImp implements UserService
{
	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<User> users() {
		return userRepo.findAll();
	}
	
	@Override
	public Optional<User> getUser(long userId) {
		return userRepo.findById(userId);
	}
	
	@Override
	public User addUser(User user) {
		userRepo.save(user);
		return user;
	}
	
	@Override
	public boolean isJobExists(Job job) {
		return userRepo.isJobExists(job);
	}

	@Override
	public List<Job> findByJobAssigned(Job job) {
		return userRepo.findByJobAssigned(job);
	}
	
}
