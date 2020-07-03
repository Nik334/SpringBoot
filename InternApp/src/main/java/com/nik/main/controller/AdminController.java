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
import com.nik.main.service.UserServiceImp;

@Controller
@RequestMapping("/admin/") 
public class AdminController {

	@Autowired
	JobServiceImp jobServiceImp;
	
	@Autowired
	UserServiceImp userServiceImp;

	@PostMapping("home")
	public String loginF() {
		return "home";
	}
	
	@GetMapping("addJob")
	public String addJob() {
		return "addJob";
	}

	@PostMapping("addJob")
	public String addJobF(Job job, Model model) {
		jobServiceImp.addJob(job);
		model.addAttribute("status", "Job added successfully...");
		return "addJob";
	}

	@GetMapping("editJob")
	public ModelAndView editJob() {
		ModelAndView mv = new ModelAndView("editJob");
		mv.addObject("jobs", jobServiceImp.getJob());
		return mv;
	}

	@RequestMapping("job/{jobId}")
	public ModelAndView getJob(@PathVariable("jobId") Long jobId) {
		ModelAndView mv = new ModelAndView("editJob");
		mv.addObject("job", jobServiceImp.getJobById(jobId));
		mv.addObject("jobs", jobServiceImp.getJob());

		return mv;
	}
	
	@GetMapping("deleteJob")
	public ModelAndView deleteJob() {
		ModelAndView mv = new ModelAndView("deleteJob");
		mv.addObject("jobs", jobServiceImp.getJob());
		return mv;
	}
	
	@PostMapping("deleteJob")
	public ModelAndView deleteJob(Long jobId) {
		ModelAndView mv = new ModelAndView("deleteJob");
		
		if(userServiceImp.isJobExists(jobServiceImp.getJobById(jobId))) {
			mv.addObject("status", "<div id=\"myAlert\" class=\"alert alert-danger\">"
										+ "Candidate(s) is assigned to Job Id " + jobId + "..."
									+ "</div>");
		}
		else {
			jobServiceImp.deleteJobById(jobId);
			mv.addObject("status", "<div id=\"myAlert\" class=\"alert alert-success\">"
										+ "Job Id " + jobId + " is deleted successfully..."
									+ "</div>");
		}
		mv.addObject("jobs", jobServiceImp.getJob());
		return mv;
	}
	
	@PostMapping("updateJob")
	public ModelAndView updateJob(Job job) {
		ModelAndView mv = new ModelAndView("editJob");
		jobServiceImp.addJob(job);
		mv.addObject("jobs", jobServiceImp.getJob());
		mv.addObject("status", "Job Id " + job.getJobId() + " is updated successfully...");
		return mv;
	}
	
	@GetMapping("assigningCandidate")
	public ModelAndView assigningCandidate() {
		ModelAndView mv = new ModelAndView("assigningCandidate");
		mv.addObject("jobs", jobServiceImp.getJob());
		return mv;
	}
	
	@PostMapping("assign")
	public ModelAndView assigningCandidate(Long jobId) {
		ModelAndView mv = new ModelAndView("assign");
		mv.addObject("jobId", jobId);
		System.out.println(jobId);
		System.out.println("Fetchh =>" + jobServiceImp.getJobById(jobId).getJobId());
		System.out.println("size=> " + userServiceImp.findByJobAssigned(jobServiceImp.getJobById(jobId)).size());
		mv.addObject("usersOnTheJob", userServiceImp.findByJobAssigned(jobServiceImp.getJobById(jobId)));
		mv.addObject("usersNotHaveJob", userServiceImp.findByJobAssigned(null));
		return mv;
	}
}
