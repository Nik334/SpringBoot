package com.nik.main.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uesrId;
	private String firstName;
	private String lastName;
	private String email;
	private String position;
	private String role;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private ZonedDateTime dateOfJoining = ZonedDateTime.now(ZoneId.of("UTC"));
	
	private boolean status;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "job_id")
	private Job jobAssigned;

	public long getUesrId() {
		return uesrId;
	}

	public void setUesrId(long uesrId) {
		this.uesrId = uesrId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public ZonedDateTime getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(ZonedDateTime dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Job getJobAssigned() {
		return jobAssigned;
	}

	public void setJobAssigned(Job jobAssigned) {
		this.jobAssigned = jobAssigned;
	}

}
