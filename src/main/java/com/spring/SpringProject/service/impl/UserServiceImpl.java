package com.spring.SpringProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringProject.model.User;
import com.spring.SpringProject.repository.UserRepository;
import com.spring.SpringProject.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void signUp(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User logIn(String email, String psw) {
		// TODO Auto-generated method stub
		return userRepo.findByEmailAndPassword(email, psw);
	}

}
