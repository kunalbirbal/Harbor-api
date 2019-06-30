package com.harbor.service;

import java.util.List;

import com.harbor.model.Appointment;
import com.harbor.model.AppointmentPatients;
import com.harbor.model.HospitalPatient;
import com.harbor.model.Patient;

public interface HospitalPatientService {
	
	public HospitalPatient createHospitalPatient(HospitalPatient hospat);
	
	
	List<HospitalPatient> getHospitalPatientsListByDoctorId(int doctorid);
	
	List<AppointmentPatients> getDoctorPatientById(int doctorid);
	
	
	List<Appointment> getAppointmentDetalisdtByPatientId(long patientid);
	
	Appointment getPatientByAppointmentId(long appointmentid);
}
