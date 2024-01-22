package com.spring.SpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.SpringProject.model.ApproveAppointment;
import com.spring.SpringProject.service.ApproveAppointmentService;
import com.spring.SpringProject.service.BookAppointmentService;

@Controller
public class ApproveAppointmentController {

	@Autowired
	private BookAppointmentService bookAppSevice;
	@Autowired
	private ApproveAppointmentService approveAppService;
	
	@GetMapping("/approveAppointment")
	public String getApproveAppointment(Model model) {
		model.addAttribute("bList",bookAppSevice.getAllBookAppointment());
		return"ApproveAppointment";
	}
	@PostMapping("/accept/approveAppointment")
	public String postAccept(@ModelAttribute ApproveAppointment approve, Model model) {
		approveAppService.acceptAppointment(approve);
		model.addAttribute("message","upload fail");
		return"redirect:/approveAppointment";
	}
	@GetMapping("/reject/appAppointment")
	public String deleteApp(@RequestParam int id) {
		approveAppService.regectAppointment(id);
		return"redirect:/approveAppointment";
	}
	
}
