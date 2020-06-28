package com.nik.main.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jobId;
	private String jobTitle;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private ZonedDateTime dateOfJobCreation;
	
	private String department;
	
	/*
	 * @OneToMany(mappedBy = "jobAssigned", cascade = {CascadeType.DETACH,
	 * CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) private
	 * List<User> users;
	 * 
	 * public void addUser(User user){ if(this.users == null){ users = new
	 * ArrayList<User>(); } users.add(user); }
	 */
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public ZonedDateTime getDateOfJobCreation() {
		return dateOfJobCreation;
	}
	public void setDateOfJobCreation(ZonedDateTime dateOfJobCreation) {
		this.dateOfJobCreation = dateOfJobCreation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	/*
	 * public List<User> getUsers() { return users; } public void
	 * setUsers(List<User> users) { this.users = users; }
	 */
}
