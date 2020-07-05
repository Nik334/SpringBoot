package com.nik.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visitor/")
public class VisitorController {

	@GetMapping("login")
	public String login() {
		return "vistorLogin";
	}
}
