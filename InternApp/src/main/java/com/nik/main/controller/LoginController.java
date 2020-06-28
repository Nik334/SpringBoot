package com.nik.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nik.main.dao.UserRepo;

@Controller
public class LoginController {
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/loginF")
	public String loginF() {
		return "home";
	}
}
