package com.harbor.model;

public class AppointmentPatients {
	
	private long patient_id;
	private long slot_id;
	private long doctor_id;
	private String name;
	private String contact;
	
	
	public long getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}
	public long getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(long slot_id) {
		this.slot_id = slot_id;
	}
	public long getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(long doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}

