package com.harbor.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.harbor.dao.IDoctorDao;
import com.harbor.model.Doctor;
import com.harbor.model.DoctorDepartment;
import com.harbor.model.Slot;

@Repository
@Transactional
public class DoctorDaoImpl implements IDoctorDao {

	@PersistenceContext
	private EntityManager emf;
	
	    
	@Override
	public Doctor findById(long id) {
		Doctor doctor = emf.find(Doctor.class, id);
		return doctor;
	}

	@Override
	public List<Doctor> getAll() {
		List<Doctor> doctors = emf.unwrap(Session.class).createCriteria(Doctor.class).list();
		return doctors;
	}

	@Override
	public List<DoctorDepartment> getDepartmentListByDoctorId(int id) {
		Criteria criteria = emf.unwrap(Session.class).createCriteria(DoctorDepartment.class);
		criteria.add(Restrictions.eq("doctor.id", (long) id));

		List<DoctorDepartment> depts = criteria.list();
		return depts;
	}

	@Override
	public List<Slot> getSlotsByDoctorIdAndDepartmentId(int docId, int departmentId, Date date) {
		Criteria criteria = emf.unwrap(Session.class).createCriteria(Slot.class);
		criteria.add(Restrictions.eq("doctor.id", (long) docId));
		criteria.add(Restrictions.eq("department.id", (long) departmentId));
		
		criteria.add(Restrictions.eq("date", date));

		List<Slot> slots = criteria.list();
		return slots;
	}


}
