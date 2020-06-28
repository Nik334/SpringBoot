package com.nik.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nik.main.model.Job;
import com.nik.main.service.JobServiceImp;

@Controller
public class HomeController {

	@Autowired
	JobServiceImp jobServiceImp;

	@GetMapping("/addJob")
	public String addJob() {
		return "addJob";
	}

	@PostMapping("/addJob")
	public String addJobF(Job job, Model model) {
		jobServiceImp.addJob(job);
		model.addAttribute("status", "Job added successfully...");
		return "addJob";
	}

	@GetMapping("/editJob")
	public ModelAndView editJob() {
		ModelAndView mv = new ModelAndView("editJob");
		mv.addObject("jobs", jobServiceImp.getJob());
		return mv;
	}
	
	@RequestMapping("/job/{ jobId }")
	public String getJob(@PathVariable("jobId") Long jobId, Model model) {
		model.addAttribute("job", jobServiceImp.getJobById(jobId));
		model.addAttribute("jobs", jobServiceImp.getJob());
		return "editJob";
	}
}
