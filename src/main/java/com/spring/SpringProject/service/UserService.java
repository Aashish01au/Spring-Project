package com.spring.SpringProject.service;

import com.spring.SpringProject.model.User;

public interface UserService {

	void signUp(User user);
	User logIn(String email, String psw);
}
