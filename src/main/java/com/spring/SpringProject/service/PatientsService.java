package com.spring.SpringProject.service;

import java.util.List;

import com.spring.SpringProject.model.Patients;

public interface PatientsService {
	
	void addPatients(Patients patients);
	void deletePatients(int id);
	void updatePatients(Patients patients);
	List<Patients>getAllPAtients();
	Patients getPatientsById(int id);

}
