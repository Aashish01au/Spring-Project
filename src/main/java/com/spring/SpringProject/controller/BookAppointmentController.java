package com.spring.SpringProject.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.SpringProject.model.BookAppointment;
import com.spring.SpringProject.model.Patients;
import com.spring.SpringProject.model.User;
import com.spring.SpringProject.repository.PatientsRepository;
import com.spring.SpringProject.service.BookAppointmentService;
import com.spring.SpringProject.service.DoctorService;
import com.spring.SpringProject.service.SpecializationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookAppointmentController {
	

	@Autowired
	private BookAppointmentService bookAppointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientsRepository  patientRepo;

	@Autowired
	private SpecializationService specializationService;

	@GetMapping("/bookAppointment")
	public String getBookAppointment(Model model, HttpSession session) {
		if (session.getAttribute("activeUser") == null) {

			return "Login";
		}

	
		model.addAttribute("dList",doctorService.getAllDoc()); 
	    model.addAttribute("sList", specializationService.getAllSpecialization());
		String[] imgNameList = new File("src/main/resources/static/img").list();
		model.addAttribute("imgList", imgNameList);

		return "BookAppointment";
	}
	
	@GetMapping("/doc/book")
	public String bookDoc(@RequestParam int id , Model model, HttpSession session) {
		
		model.addAttribute("dModel",doctorService.getDoctorById(id));
		
		User  user = (User) session.getAttribute("activeUser");
		Patients  patient = patientRepo.findByEmail(user.getEmail());
		
		 BookAppointment  bookApp = new BookAppointment();
		 bookApp.setDoctor(doctorService.getDoctorById(id));
		 bookApp.setPatient(patient); 
		 bookAppointmentService.addBookAppointment(bookApp);
		
		return"redirect:/bookAppointment";
	}
	
	

}
