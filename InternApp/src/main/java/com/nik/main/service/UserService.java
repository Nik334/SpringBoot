package com.nik.main.service;

import java.util.List;

import com.nik.main.model.Job;
import com.nik.main.model.User;

public interface UserService {
	public List<User> users();
	
	public User getUser(long userId);
	
	public User addUser(User user);
	
	public boolean isJobExists(Job job);
	
	public List<User> findByJobAssigned(Job job);
	
	public boolean isUserExists(Long userId);
	
	public User addJobId(Job job, User user);
}
