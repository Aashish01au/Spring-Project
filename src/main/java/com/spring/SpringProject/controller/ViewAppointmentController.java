package com.spring.SpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewAppointmentController {

	@GetMapping("/viewAppointment")
	public String getViewAppointment(HttpSession session) {
			if(session.getAttribute("activeUser")==null) {
			
			return"Login";
		}
		return"ViewAppointment";
	}
	
}
