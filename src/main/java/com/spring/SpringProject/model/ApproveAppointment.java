package com.spring.SpringProject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="approve_App_Tbl")
public class ApproveAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="boook_Appointment_ID")
	private BookAppointment bookAppointment;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BookAppointment getBookAppointment() {
		return bookAppointment;
	}
	public void setBookAppointment(BookAppointment bookAppointment) {
		this.bookAppointment = bookAppointment;
	}
	

}
