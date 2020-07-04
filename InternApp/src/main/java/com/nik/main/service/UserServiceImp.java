package com.nik.main.service;

import java.util.List;

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
	public User getUser(long userId) {
		return userRepo.findById(userId).orElse(null);
	}
	
	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public boolean isJobExists(Job job) {
		return userRepo.isJobExists(job);
	}

	@Override
	public List<User> findByJobAssigned(Job job) {
		return userRepo.findByJobAssigned(job);
	}

	@Override
	public boolean isUserExists(Long userId) {
		return userRepo.existsById(userId);
	}

	@Override
	public User addJobId(Job job, User user) {
		user.setJobAssigned(job);
		return userRepo.save(user);
	}
	
}
