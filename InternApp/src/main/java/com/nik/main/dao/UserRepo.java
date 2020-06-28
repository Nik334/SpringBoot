package com.nik.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nik.main.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
