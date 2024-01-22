package com.spring.SpringProject.service;

import java.util.List;

import com.spring.SpringProject.model.Appointment;

public interface AppointmentService {
	
	void addAppointment(Appointment appointment);
	void deleteAppointment(int id);
	void updateAppointment(Appointment appointment);
	Appointment getAppointmentById(int id);
	List<Appointment> getAllAppointment();
	

}
