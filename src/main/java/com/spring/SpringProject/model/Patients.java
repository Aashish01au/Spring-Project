package com.spring.SpringProject.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Patients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fName;
	private String lName;
	private String gender;
	private String phone;
	private String email;
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;
	private String materialStatus;
	@Column(columnDefinition = "LongText")
	private String presentAddress;
	@Column(columnDefinition = "LongText")
	private String communicationAddress;
	@ElementCollection
	@CollectionTable
	private List<String> pastMedicalHistory;
	
	@Column(columnDefinition = "LongText")
	private String otherDetails;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getMaterialStatus() {
		return materialStatus;
	}
	public void setMaterialStatus(String materialStatus) {
		this.materialStatus = materialStatus;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getCommunicationAddress() {
		return communicationAddress;
	}
	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
	public List<String> getPastMedicalHistory() {
		return pastMedicalHistory;
	}
	public void setPastMedicalHistory(List<String> pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
