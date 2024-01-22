package com.spring.SpringProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.SpringProject.model.Patients;
import com.spring.SpringProject.model.User;
import com.spring.SpringProject.service.PatientsService;
import com.spring.SpringProject.service.UserService;
import com.spring.SpringProject.utils.MailUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class PatientsController {
	
	@Autowired
	private MailUtils mailUtils;

	@Autowired
	private PatientsService patientsService;
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/patients")
	public String getPatients(HttpSession session) {
			if(session.getAttribute("activeUser")==null) {
			
			return"Login";
		}
		return"Patients";
	}

	@PostMapping("/patients")
	public String postPatients(@ModelAttribute Patients patients , @ModelAttribute User user) {
		patientsService.addPatients(patients);	
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		user.setUserName(patients.getfName());
		user.setRole("PATIENT");
		userService.signUp(user);
		
		return"Patients";
	}
	@GetMapping("/patient_home")
	public String getHomePatients() {
		
		return"Patient_home";
	}
	@GetMapping("/patient_Profile")
	public String getPatProfile() {
		return"PatientProfile";
	}
	
	@GetMapping("/patient_mail")
	public String getPatientMail() {
		
		return"Patient_Mail";
	}
	@PostMapping("/patient_mail")
	public String postPatientMail(@RequestParam String toEmail, @RequestParam String subject, @RequestParam String message) {
		mailUtils.sendEmail(toEmail, subject, message);
		return"redirect:/patient_mail";
	}
}
