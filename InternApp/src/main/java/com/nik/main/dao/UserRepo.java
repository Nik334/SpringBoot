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
	
	@Query("from User where jobAssigned = ?1 and (position = 'candidate' or position = 'visitor')")
	public List<User> findByJobAssigned(Job job);
	
	@Query("from User where jobAssigned is null and (position = 'candidate' or position = 'visitor')")
	public List<User> findByJobAssignedForNull();
	
	@Query("from User where email = ?1 and position = 'admin'")
	public User findByEmailForAdmin(@Param("email") String email);
	
	@Query("from User where email = ?1 and position = 'visitor'")
	public User findByEmailForVisitor(@Param("email") String email);
	
}
