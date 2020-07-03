package com.nik.main.service;

import java.util.List;
import java.util.Optional;

import com.nik.main.model.Job;
import com.nik.main.model.User;

public interface UserService {
	public List<User> users();
	
	public Optional<User> getUser(long userId);
	
	public User addUser(User user);
	
	public boolean isJobExists(Job job);
	
	public List<Job> findByJobAssigned(Job job);
}
