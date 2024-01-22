package com.spring.SpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.SpringProject.service.DoctorService;

@Controller
public class Doctor_List_Controller {

	@Autowired
	private DoctorService docService;
	
	@GetMapping("/doctor_list")
	public String getDocList(Model model) {
		model.addAttribute("dList",docService.getAllDoc());
		return"Doctor_list";
	}
	@GetMapping("/remove/doctor")
	public String deleteDoctor(@RequestParam int id) {
		docService.deleteDoctor(id);
		return"redirect:/doctor_list";
	}
	
}
