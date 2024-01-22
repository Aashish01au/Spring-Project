package com.spring.SpringProject.service;

import java.util.List;

import com.spring.SpringProject.model.Doctor;

public interface DoctorService  {

	
	void addDoctor(Doctor doctor);
	void deleteDoctor(int id);
	void updateDoctor(Doctor doctor);
	List<Doctor> getAllDoc();
	Doctor getDoctorById(int id);
}
