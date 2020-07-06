package com.nik.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nik.main.model.User;
import com.nik.main.model.UserLogin;
import com.nik.main.service.LoginServiceImp;
import com.nik.main.service.UserServiceImp;

@Controller
@RequestMapping("/candidate/")
public class CandidateController {
	
	@Autowired
	LoginServiceImp loginServiceImp;

	@Autowired
	UserServiceImp userServiceImp;
	
	@GetMapping("addUser")
	public String login() {
		return "addCandidate";
	}
	
	@PostMapping("addUser")
	public String login(String firstName, String lastName, String email, String role, String password, Model model) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setRole(role);
		user.setPosition("candidate");
		user.setStatus(true);
		userServiceImp.addUser(user);
		
		UserLogin userLogin = new UserLogin();
		userLogin.setUser(user);
		userLogin.setPassword(password);
		loginServiceImp.addLogin(userLogin);
		
		model.addAttribute("status", "Candidate added successfully");
		return "addCandidate";
	}
}
