package com.nik.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nik.main.model.Job;
import com.nik.main.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query("select count(jobAssigned)>0 from User where jobAssigned = ?1")
	public boolean isJobExists(@Param("jobAssigned") Job job);
	
	public List<Job> findByJobAssigned(Job job);
}
