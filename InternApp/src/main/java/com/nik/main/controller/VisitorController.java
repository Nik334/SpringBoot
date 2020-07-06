package com.nik.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nik.main.model.Job;
import com.nik.main.model.User;
import com.nik.main.service.LoginServiceImp;
import com.nik.main.service.UserServiceImp;

@Controller
@RequestMapping("/visitor/")
public class VisitorController {
	@Autowired
	UserServiceImp userServiceImp;
	
	@Autowired
	LoginServiceImp loginServiceImp;
	
	@GetMapping("login")
	public String login() {
		return "visitorLogin";
	}
	
	@PostMapping("login")
	public String login(String email, String password, Model model) {
		User user = userServiceImp.findByEmailForVisitor(email);
		if(user != null) {
			if(loginServiceImp.isExists(user, password)) {
				Job job = user.getJobAssigned();
				if(job == null) {
					model.addAttribute("status", "No Job found...");
					model.addAttribute("job", job);
				}else {
					List<User> usersOnTheJob = userServiceImp.findByJobAssigned(job);
					model.addAttribute("usersOnTheJob", usersOnTheJob);
				}
				return "visitorHome";
			}
			else {
				System.out.println("visitorLogin");
				model.addAttribute("status", "Login Failed... Credintial incorrect");
				return "visitorLogin";
			}
		}
		else {
			System.out.println("status fail");
			model.addAttribute("status", "Login Failed... Credintial incorrect");
			return "visitorLogin";
		}
	}
}
