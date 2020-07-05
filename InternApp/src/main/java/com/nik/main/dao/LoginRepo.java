package com.nik.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nik.main.model.User;
import com.nik.main.model.UserLogin;

@Repository
public interface LoginRepo extends JpaRepository<UserLogin, Long>{
	
	@Query("from UserLogin where userId = ?1 and password = ?2")
	public UserLogin isUserAndPasswordExits(User user, String password);
}
