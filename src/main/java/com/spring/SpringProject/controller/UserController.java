package com.spring.SpringProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.SpringProject.model.User;
import com.spring.SpringProject.service.UserService;
import com.spring.SpringProject.utils.MailUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class); 
	@Autowired
	private MailUtils mailUtils;
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/login","/"})
	public String getLogin() {
		log.info("------------inside Login page");
		return"Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr=userService.logIn(user.getEmail(), user.getPassword());
	
		
		if(usr !=null) {
			
			log.info("------------LOgin Successfull----------");
			
			session.setAttribute("activeUser", usr);
			session.setMaxInactiveInterval(200);
			
			if(usr.getRole().equals("PATIENT")){
				return"Patient_Home";
			}else if(usr.getRole().equals("DOCTOR")) {
					return"Doctor_Home";
				}
			
			return"Home";
		}
		model.addAttribute("message","User Not Found !!!");
		return"Login";
		
	}
	@GetMapping("/home")
	public String home(HttpSession session) {
		if(session.getAttribute("activeUser")==null) {
			log.info("-----------------inside Home Page-------------");
			
			return"Login";
		}
		return"Home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		log.info("--------------Logout Successful------------");
		session.invalidate();
		return"Login";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		log.info("--------------inside Signup Form-----------");
		return"Signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		log.info("----------------Signup Successful---------------");
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		user.setRole("ADMIN");
		userService.signUp(user);
		
		return"Login";
	}
	
	@GetMapping("/admin_mail")
	public String getAdminMail() {
		return"Admin_Mail";
	}
	@PostMapping("/admin_mail")
	public String postAdminMail(@RequestParam String toEmail, @RequestParam String subject, @RequestParam String message) {
		mailUtils.sendEmail(toEmail, subject, message);
		return"redirect:/admin_mail";
	}
	
	
}
