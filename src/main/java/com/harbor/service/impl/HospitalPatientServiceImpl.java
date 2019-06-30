package com.harbor.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.dao.IDoctorPatientDao;
import com.harbor.model.Appointment;
import com.harbor.model.AppointmentPatients;
import com.harbor.model.HospitalPatient;
import com.harbor.model.Patient;
import com.harbor.service.HospitalPatientService;

@Service
@Transactional
public class HospitalPatientServiceImpl implements HospitalPatientService {
	
	@Autowired
	IDoctorPatientDao hospatdao;
	
	@Override
	public HospitalPatient createHospitalPatient(HospitalPatient hospat) {
		
		return hospatdao.insertHospitalPatient(hospat);
	}
	
	
	
	@Override
	public List<HospitalPatient> getHospitalPatientsListByDoctorId(int doctorid) {
		
		return hospatdao.getHospitalPatientByDoctorId(doctorid);
		
	}

	
	@Override
	public List<AppointmentPatients> getDoctorPatientById(int doctorid) {
	
		return hospatdao.getDoctorPatientById(doctorid);
	}
	
	
	
	@Override
	public List<Appointment> getAppointmentDetalisdtByPatientId(long patientid) {
		return hospatdao.getAppointmentByPatientId(patientid);
	}
	
	
	
	@Override
	public Appointment getPatientByAppointmentId(long appointmentid) {
		
		return hospatdao.getPatietByAppointmentId(appointmentid);
	}
}
