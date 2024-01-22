package com.spring.SpringProject.service;

import java.util.List;

import com.spring.SpringProject.model.Specialization;

public interface SpecializationService {

	void addSpecialization(Specialization Specialization);
	void deleteSpecialization(int id);
	void updateSpecializaton(Specialization specialization);
	List<Specialization>getAllSpecialization();
	Specialization getSpecializationById(int id);
	
	
}
