package com.spring.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SpringProject.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	Doctor findByEmail(String email);
	
	

}
