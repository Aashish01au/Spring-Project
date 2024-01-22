package com.spring.SpringProject.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name="appointment_tbl")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	@DateTimeFormat(iso = ISO.DATE)
	private String date;
	@DateTimeFormat(iso=ISO.TIME)
	private String time;
	private int noOfSlots;
	
	private String details;
	private int consultationFee;
	
	
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNoOfSlots() {
		return noOfSlots;
	}
	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(int consultationFee) {
		this.consultationFee = consultationFee;
	}
	
	
	

}
