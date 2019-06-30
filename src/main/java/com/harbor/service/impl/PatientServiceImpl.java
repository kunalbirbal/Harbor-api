package com.harbor.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.dao.IPatientDao;
import com.harbor.model.Appointment;
import com.harbor.model.Patient;
import com.harbor.service.IPatientService;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	@Autowired
	IPatientDao patientDao;

	@Override
	public Patient getPatientByMobile(String mobile) {

		return patientDao.findByMobile(mobile);

	}

	@Override
	public Patient createPatient(Patient patient) {
		patient.setCreated(new Date());
		patient.setUpdated(new Date());

		return patientDao.savePatient(patient);

	}
	
	
	@Override
	public Patient editPatient(Patient patient) {

		return patientDao.updatePateint(patient);
	}

	
	
	@Override
	public List<Appointment> getPatientMedicalHistory(long id) {
		
		return patientDao.getPatientMedicalHistory(id);
	}
	
	
	
	@Override
	public Appointment getPatientAppointmentDetalisByID(long id) {
	
		return patientDao.getPatientMedicalDetailsByID(id);
	}

	@Override
	public Patient getPatientById(long id) {
		
		return patientDao.findById(id);
	}
}
