package com.nik.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nik.main.model.User;

@Controller
@RequestMapping("/candidate/")
public class CandidateController {
	@GetMapping("addUser")
	public String login() {
		return "login";
	}
	
	@PostMapping("addUser")
	public String login(User user) {
		return "login";
	}
}
