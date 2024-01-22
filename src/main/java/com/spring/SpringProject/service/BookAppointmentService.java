package com.spring.SpringProject.service;

import java.util.List;

import com.spring.SpringProject.model.ApproveAppointment;
import com.spring.SpringProject.model.BookAppointment;

public interface BookAppointmentService {
	
	void addBookAppointment(BookAppointment bookApp);	
	void deleteBookAppointment(int id);
	void updateBookAppointment(BookAppointment bookAppointment);
	List<BookAppointment>getAllBookAppointment();
	BookAppointment getBookAppointmentById(int id);

}
