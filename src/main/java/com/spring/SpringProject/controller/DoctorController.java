package com.spring.SpringProject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.SpringProject.model.Doctor;
import com.spring.SpringProject.model.User;
import com.spring.SpringProject.service.DoctorService;
import com.spring.SpringProject.service.SpecializationService;
import com.spring.SpringProject.service.UserService;
import com.spring.SpringProject.utils.MailUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorController {

	@Autowired
	private MailUtils mailUtils;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SpecializationService specializationService;

	@Autowired
	private UserService userService;

	@GetMapping("/doctor")
	public String getDoctor(Model model, HttpSession session) {
				
		 model.addAttribute("sList", specializationService.getAllSpecialization());
		return "Doctor";
	}

	@PostMapping("/doctor")
	public String postDoctor(@ModelAttribute Doctor doctor, @RequestParam MultipartFile images, Model model) {

		if (!images.isEmpty()) {

			try {
				Files.copy(images.getInputStream(),
						Path.of("src/main/resources/static/img/" + images.getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);

				doctor.setPhotos(images.getOriginalFilename());
				doctorService.addDoctor(doctor);

				  User user = new User();
			      user.setfName(doctor.getName());
				 user.setPassword(DigestUtils.md5DigestAsHex(doctor.getPassword().getBytes()));
				  user.setUserName(doctor.getName());
				  user.setEmail(doctor.getEmail());
				  user.setRole("DOCTOR");
				  userService.signUp(user);
				  model.addAttribute("message","Register Success!!!");
				
				return "redirect:/doctor";

			} catch (IOException e) {
				e.printStackTrace();
				return "redirect:/doctor";
			}
		}
		model.addAttribute("message", "Upload Failed!!!");
		return "redirect:/doctor";
	}

	@GetMapping("/doctor_Home")
	public String getHomeDoc() {
		return "Doctor_Home";
	}
	@GetMapping("/doctor_Profile")
	public String getDocProfile() {
		return"DoctorProfile";
	}
	
	@GetMapping("/doctor_mail")
	public String getDocMail() {
		return"Doctor_Mail";
	}
	@PostMapping("/doctor_mail")
	public String postDocMail(@RequestParam String toEmail, @RequestParam String subject,@RequestParam String message) {
		mailUtils.sendEmail(toEmail, subject, message);
		return"redirect:/doctor_mail";
	}
}
