package com.nik.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nik.main.dao.JobRepo;
import com.nik.main.model.Job;

@RestController
public class JobServiceImp implements JobService{

	@Autowired
	JobRepo jobRepo;
	
	@Override
	public List<Job> getJob() {
		return jobRepo.findAll();
	}
	
	@Override
	public Optional<Job> getJob(Long jobId) {
		return jobRepo.findById(jobId);
	}
	
	@Override
	public Job addJob(Job job) {
		return jobRepo.save(job);
	}

	@Override
	public Job getJobById(Long jobId) {
		return jobRepo.findById(jobId).orElse(null);
	}

	@Override
	public void deleteJobById(Long jobId) {
		jobRepo.deleteById(jobId);
	}
	
	public void updateJobById() {
		/* jobRepo. */
	}

	@Override
	public boolean isJobIdExists(Long jobId) {
		return jobRepo.existsById(jobId);
		
	}
	
}
