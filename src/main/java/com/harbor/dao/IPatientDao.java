package com.harbor.dao;

import java.util.List;

import com.harbor.model.Appointment;
import com.harbor.model.Patient;
import com.harbor.model.User;

public interface IPatientDao {

	Patient findById(long id);

	List<Patient> getAll();

	Patient findByMobile(String mobile);

	Patient savePatient(Patient patient);
	
	public Patient updatePateint(Patient patient);
	
	public List<Appointment> getPatientMedicalHistory(long  id);
	
	public Appointment getPatientMedicalDetailsByID(long id);
	

}
