package com.spring.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SpringProject.model.BookAppointment;

public interface BookAppointmentRepository  extends JpaRepository<BookAppointment, Integer>{

}
