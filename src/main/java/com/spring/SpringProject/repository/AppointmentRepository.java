package com.spring.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SpringProject.model.Appointment;

public interface AppointmentRepository  extends JpaRepository<Appointment, Integer>{

}
