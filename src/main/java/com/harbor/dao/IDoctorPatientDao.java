package com.harbor.dao;

import java.util.List;

import com.harbor.model.Appointment;
import com.harbor.model.AppointmentPatients;
import com.harbor.model.HospitalPatient;
import com.harbor.model.Patient;

public interface IDoctorPatientDao {
	public HospitalPatient insertHospitalPatient(HospitalPatient hospat);
	
	
	public List<HospitalPatient> getHospitalPatientByDoctorId(int doctorid);
	
	public List<AppointmentPatients> getDoctorPatientById(int doctorid);
	
	public List<Appointment> getAppointmentByPatientId(long patientid);
	
	public Appointment getPatietByAppointmentId(long appointmentid);
}
