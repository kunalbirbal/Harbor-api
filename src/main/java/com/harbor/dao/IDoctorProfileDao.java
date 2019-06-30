package com.harbor.dao;

import com.harbor.model.Doctor;

public interface IDoctorProfileDao {

	public Doctor getDoctorByID(long id);
	public Doctor editById(Doctor doctor);
}
