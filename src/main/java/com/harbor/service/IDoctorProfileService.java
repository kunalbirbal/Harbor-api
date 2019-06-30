package com.harbor.service;

import com.harbor.model.Doctor;

public interface IDoctorProfileService {
	
	public Doctor viewDoctorByID(long id);
	public Doctor editDoctor(Doctor doctor);

}
