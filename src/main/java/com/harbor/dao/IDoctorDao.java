package com.harbor.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.harbor.model.Doctor;
import com.harbor.model.DoctorDepartment;
import com.harbor.model.Slot;

public interface IDoctorDao {

	Doctor findById(long id);

	List<Doctor> getAll();

	List<DoctorDepartment> getDepartmentListByDoctorId(int id);
	
	List<Slot> getSlotsByDoctorIdAndDepartmentId(int docId, int departmentId, Date date);

}
