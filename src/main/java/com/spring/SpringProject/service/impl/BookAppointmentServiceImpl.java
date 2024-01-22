package com.spring.SpringProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringProject.model.ApproveAppointment;
import com.spring.SpringProject.model.BookAppointment;
import com.spring.SpringProject.repository.BookAppointmentRepository;
import com.spring.SpringProject.service.BookAppointmentService;

@Service
public class BookAppointmentServiceImpl implements BookAppointmentService {
	
	@Autowired
	private BookAppointmentRepository bookAppointmentRepo;

	@Override
	public void addBookAppointment(BookAppointment bookAppointment) {
	
		bookAppointmentRepo.save(bookAppointment);
	}

	@Override
	public void deleteBookAppointment(int id) {
		bookAppointmentRepo.deleteById(id);
	}

	@Override
	public void updateBookAppointment(BookAppointment bookAppointment) {
		bookAppointmentRepo.save(bookAppointment);
	}

	@Override
	public List<BookAppointment> getAllBookAppointment() {
		
		return bookAppointmentRepo.findAll();
	}

	@Override
	public BookAppointment getBookAppointmentById(int id) {
		return bookAppointmentRepo.findById(id).get();
	}


	
	

}
