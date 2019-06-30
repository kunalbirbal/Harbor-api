package com.harbor.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.dao.IDoctorDao;
import com.harbor.model.Doctor;
import com.harbor.model.DoctorDepartment;
import com.harbor.model.Slot;
import com.harbor.service.IDoctorService;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao doctorDao;

	public List<Doctor> getDoctorList() {

		return doctorDao.getAll();

	}
	
	@Override
	public List<DoctorDepartment> getDepartmentListByDoctorId(int id) {
		return doctorDao.getDepartmentListByDoctorId(id);
	}
	
	@Override
	public List<Slot> getSlotsByDoctorIdAndDepartmentId(int docId, int deptId, Date date) throws ParseException {
		return doctorDao.getSlotsByDoctorIdAndDepartmentId(docId, deptId,date);
	}


}
