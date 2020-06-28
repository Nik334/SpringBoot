package com.nik.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nik.main.model.Job;

public interface JobRepo extends JpaRepository<Job, Long> {

}
