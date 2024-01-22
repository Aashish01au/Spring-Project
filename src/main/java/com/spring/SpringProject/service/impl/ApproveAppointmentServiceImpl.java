package com.spring.SpringProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringProject.model.ApproveAppointment;
import com.spring.SpringProject.repository.ApproveAppointmentRepository;
import com.spring.SpringProject.service.ApproveAppointmentService;
@Service
public class ApproveAppointmentServiceImpl implements ApproveAppointmentService {

	@Autowired
	private ApproveAppointmentRepository approveAppointmentRepo;
	
	@Override
	public void acceptAppointment(ApproveAppointment approveAppointment) {
		approveAppointmentRepo.save(approveAppointment);
	}

	@Override
	public void regectAppointment(int id) {
		approveAppointmentRepo.deleteById(id);
	}

	@Override
	public List<ApproveAppointment> getAllAppointment() {
		
		return approveAppointmentRepo.findAll();
	}

	@Override
	public ApproveAppointment getAppointmentById(int id) {

		return approveAppointmentRepo.findById(id).get();
	}

}
