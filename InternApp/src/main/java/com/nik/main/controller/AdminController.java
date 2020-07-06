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
import com.nik.main.model.User;
import com.nik.main.model.UserLogin;
import com.nik.main.service.JobServiceImp;
import com.nik.main.service.LoginServiceImp;
import com.nik.main.service.UserServiceImp;

@Controller
@RequestMapping("/admin/") 
public class AdminController {
	
	@Autowired
	LoginServiceImp loginServiceImp;

	@Autowired
	JobServiceImp jobServiceImp;
	
	@Autowired
	UserServiceImp userServiceImp;
	
	@GetMapping("login")
	public String login() {
		return "adminLogin";
	}

	@PostMapping("login")
	public String login(String email, String password, Model model) {
		User user = userServiceImp.findByEmailForAdmin(email);
		if(user != null) {
			if(loginServiceImp.isExists(user, password)) {
				return "home";
			}
			else {
				model.addAttribute("status", "Login Failed... Credintial incorrect");
				return "adminLogin";
			}
		}
		else {
			model.addAttribute("status", "Login Failed... Credintial incorrect");
			return "adminLogin";
		}
	}
	
	@GetMapping("addJob")
	public String addJob() {
		return "addJob";
	}

	@PostMapping("addJob")
	public String addJobF(Job job, Model model) {
		jobServiceImp.addJob(job);
		model.addAttribute("status", "Job added successfully...");
		model.addAttribute("jobId", job.getJobId());
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
	
	@GetMapping("assign")
	public ModelAndView assign(Long jobId) {
		ModelAndView mv = new ModelAndView("assign");
		if(jobServiceImp.isJobIdExists(jobId)) {
			mv.addObject("jobId", jobId);
			
			mv.addObject("usersOnTheJob", userServiceImp.findByJobAssigned(jobServiceImp.getJobById(jobId)));
			mv.addObject("usersNotHaveJob", userServiceImp.findByJobAssignedForNull());
		}
		else {
			mv.addObject("status", "Job does't exists...");
		}
		
		return mv;
	}
	
	@GetMapping("assignUser")
	public ModelAndView assignUser(Long jobId, Long userId) {
		ModelAndView mv = new ModelAndView("assign");
		if(jobServiceImp.isJobIdExists(jobId)) {
			mv.addObject("jobId", jobId);
			if(userServiceImp.isUserExists(userId)) {
				userServiceImp.addJobId(jobServiceImp.getJobById(jobId), userServiceImp.getUser(userId));
			}else {
				mv.addObject("status", "User does't exists...");
			}
			mv.addObject("usersOnTheJob", userServiceImp.findByJobAssigned(jobServiceImp.getJobById(jobId)));
			mv.addObject("usersNotHaveJob", userServiceImp.findByJobAssignedForNull());
		}
		else {
			mv.addObject("status", "Job does't exists...");
		}
		
		return mv;
	}
	
	@GetMapping("removeUser")
	public ModelAndView removeUser(Long jobId, Long userId) {
		ModelAndView mv = new ModelAndView("assign");
		if(jobServiceImp.isJobIdExists(jobId)) {
			mv.addObject("jobId", jobId);
			if(userServiceImp.isUserExists(userId)) {
				userServiceImp.addJobId(null, userServiceImp.getUser(userId));
			}else {
				mv.addObject("status", "User does't exists...");
			}
			mv.addObject("usersOnTheJob", userServiceImp.findByJobAssigned(jobServiceImp.getJobById(jobId)));
			mv.addObject("usersNotHaveJob", userServiceImp.findByJobAssignedForNull());
		}
		else {
			mv.addObject("status", "Job does't exists...");
		}
		
		return mv;
	}
	
	@GetMapping("addVisitor")
	public String addVisitor() {
		return "addVisitor";
	}
	
	@PostMapping("addVisitor")
	public String addVisitor(String firstName, String lastName, String email, String password, Model model) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPosition("visitor");
		user.setStatus(true);
		userServiceImp.addUser(user);
		
		UserLogin userLogin = new UserLogin();
		userLogin.setUser(user);
		userLogin.setPassword(password);
		loginServiceImp.addLogin(userLogin);
		
		model.addAttribute("status", "Visitor added successfully");
		return "addVisitor";
	}
}
