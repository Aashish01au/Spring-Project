package com.spring.SpringProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringProject.model.Specialization;
import com.spring.SpringProject.repository.SpecializationRepository;
import com.spring.SpringProject.service.SpecializationService;
@Service
public class SpecializationServiceImpl implements SpecializationService{

	@Autowired
	private SpecializationRepository SpecializationRepo;
	
	@Override
	public void addSpecialization(Specialization Specialization) {
		
		SpecializationRepo.save(Specialization);
		
	}

	@Override
	public void deleteSpecialization(int id) {
		SpecializationRepo.deleteById(id);
		
	}

	@Override
	public void updateSpecializaton(Specialization specialization) {
		SpecializationRepo.save(specialization);
		
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		// TODO Auto-generated method stub
		return SpecializationRepo.findAll();
	}

	@Override
	public Specialization getSpecializationById(int id) {
		// TODO Auto-generated method stub
		return SpecializationRepo.findById(id).get();
	}

}
