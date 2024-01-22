package com.spring.SpringProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringProject.model.Appointment;
import com.spring.SpringProject.repository.AppointmentRepository;
import com.spring.SpringProject.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Override
	public void addAppointment(Appointment appointment) {
		
		appointmentRepo.save(appointment);
	}

	@Override
	public void deleteAppointment(int id) {
		appointmentRepo.deleteById(id);
		
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		appointmentRepo.save(appointment);
		
	}

	@Override
	public Appointment getAppointmentById(int id) {
		// TODO Auto-generated method stub
		return appointmentRepo.findById(id).get();
	}

	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		return appointmentRepo.findAll();
	}

}
