package com.nik.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nik.main.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
