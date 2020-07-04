package com.nik.main.service;

import java.util.List;
import java.util.Optional;

import com.nik.main.model.Job;

public interface JobService {
	
	public List<Job> getJob();
	
	public Optional<Job> getJob(Long jobId);
	
	public Job addJob(Job job);
	
	public Job getJobById(Long jobId);
	
	public void deleteJobById(Long jobId);
	
	public boolean isJobIdExists(Long jobId);
}
