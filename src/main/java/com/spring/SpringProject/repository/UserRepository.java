package com.spring.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SpringProject.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmailAndPassword(String email, String psw);

}
