package com.harbor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.dao.IDoctorProfileDao;
import com.harbor.model.Doctor;
import com.harbor.service.IDoctorProfileService;

@Service
@Transactional
public class DoctorProfileServiceImpl implements IDoctorProfileService{

	
	@Autowired
	 IDoctorProfileDao docdao;
	
	
	public Doctor viewDoctorByID(long id) {
		
		return docdao.getDoctorByID(id);
	}


	@Override
	public Doctor editDoctor(Doctor doctor) {		
		return docdao.editById(doctor);
	}
}
