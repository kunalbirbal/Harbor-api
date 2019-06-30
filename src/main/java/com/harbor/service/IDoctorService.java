package com.harbor.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.harbor.model.Doctor;
import com.harbor.model.DoctorDepartment;
import com.harbor.model.Slot;

public interface IDoctorService {

	List<Doctor> getDoctorList();

	List<DoctorDepartment> getDepartmentListByDoctorId(int id);

	List<Slot> getSlotsByDoctorIdAndDepartmentId(int docId, int deptId, Date date) throws ParseException;
	
	
}
