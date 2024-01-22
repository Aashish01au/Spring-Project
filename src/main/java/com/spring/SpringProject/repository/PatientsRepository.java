package com.spring.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SpringProject.model.Patients;

public interface PatientsRepository  extends JpaRepository<Patients, Integer>{

	  Patients   findByEmail(String email);
}
