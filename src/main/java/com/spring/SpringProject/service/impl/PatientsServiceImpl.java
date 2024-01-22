package com.spring.SpringProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringProject.model.Patients;
import com.spring.SpringProject.repository.PatientsRepository;
import com.spring.SpringProject.service.PatientsService;

@Service
public class PatientsServiceImpl implements PatientsService {

	@Autowired
	private PatientsRepository patientsRepo;
	
	@Override
	public void addPatients(Patients patients) {
		patientsRepo.save(patients);
		
	}

	@Override
	public void deletePatients(int id) {
		patientsRepo.deleteById(id);
		
	}

	@Override
	public void updatePatients(Patients patients) {
		patientsRepo.save(patients);
		
	}

	@Override
	public List<Patients> getAllPAtients() {
	
		return patientsRepo.findAll();
	}

	@Override
	public Patients getPatientsById(int id) {
		// TODO Auto-generated method stub
		return patientsRepo.findById(id).get();
	}




}
