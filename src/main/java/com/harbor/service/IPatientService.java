package com.harbor.service;

import java.util.List;

import com.harbor.model.Appointment;
import com.harbor.model.Patient;

public interface IPatientService {

	Patient getPatientByMobile(String mobile);

	Patient createPatient(Patient patient);
	
	public Patient editPatient(Patient patient);
	
	public Patient getPatientById(long id);
	
	public List<Appointment> getPatientMedicalHistory(long id);
	
	public Appointment  getPatientAppointmentDetalisByID(long id);
 
}
