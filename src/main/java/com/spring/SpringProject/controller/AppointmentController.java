package com.spring.SpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.SpringProject.model.Appointment;
import com.spring.SpringProject.repository.DoctorRepository;
import com.spring.SpringProject.service.AppointmentService;
import com.spring.SpringProject.service.DoctorService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AppointmentController {

	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/appointment")
	public String getAppointment(Model model,HttpSession session) {
			if(session.getAttribute("activeUser")==null) {
			
			return"Login";
		}
		
		model.addAttribute("dList",doctorService.getAllDoc());
		return"Appointment";
	}
	
	@PostMapping("/appointment")
	public String postAppointment(@ModelAttribute Appointment appointment) {
		appointmentService.addAppointment(appointment);
		return"redirect:/appointment";
	}
	
}
