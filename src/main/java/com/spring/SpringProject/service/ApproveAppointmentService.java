package com.spring.SpringProject.service;

import java.util.List;

import com.spring.SpringProject.model.ApproveAppointment;

public interface ApproveAppointmentService {
	void acceptAppointment(ApproveAppointment approveAppointment);
	void regectAppointment(int id);
	List<ApproveAppointment>getAllAppointment();
	ApproveAppointment getAppointmentById(int id);

}
