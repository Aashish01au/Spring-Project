package com.spring.SpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.SpringProject.model.Specialization;
import com.spring.SpringProject.service.SpecializationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SpecializationController {
	@Autowired
	private SpecializationService specializationService;
	
	@GetMapping("/specialization")
	public String getSpecialization(HttpSession session) {
 if(session.getAttribute("activeUser")==null) {
			
			return"Login";
		}
		return"Specialization";
	}
	@PostMapping("/specialization")
	public String postSpecialization(@ModelAttribute Specialization specialization) {
		specializationService.addSpecialization(specialization);
		return"Specialization";
	}

}
