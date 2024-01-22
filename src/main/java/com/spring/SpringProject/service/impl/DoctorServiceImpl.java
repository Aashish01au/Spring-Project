package com.spring.SpringProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringProject.model.Doctor;
import com.spring.SpringProject.repository.DoctorRepository;
import com.spring.SpringProject.service.DoctorService;

@Service
public class DoctorServiceImpl  implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepo;
	
	@Override
	public void addDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
		
	}

	@Override
	public void deleteDoctor(int id) {
		doctorRepo.deleteById(id);
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
		
	}

	@Override
	public List<Doctor> getAllDoc() {
		// TODO Auto-generated method stub
		return doctorRepo.findAll();
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepo.findById(id).get();
	}

}
