package com.harbor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.harbor.dao.IPatientDao;
import com.harbor.model.Appointment;
import com.harbor.model.Doctor;
import com.harbor.model.DoctorDepartment;
import com.harbor.model.Patient;
import com.harbor.model.Slot;
import com.harbor.model.User;

import scala.annotation.meta.setter;

@Repository
@Transactional
public class PatientDaoImpl implements IPatientDao {
	
	@PersistenceContext
	private EntityManager emf;
	
	@Autowired
	HibernateTemplate ht;
	
	@Override
	public Patient findById(long id) {
		Patient patient = emf.find(Patient.class, id);		
		return patient;
	}
	
	
	@Override
	public Patient findByMobile(String mobile) {
				
		Criteria criteria = emf.unwrap(Session.class).createCriteria(Patient.class);
		criteria.add(Restrictions.eq("contact", mobile));

		Patient patient = (Patient) criteria.uniqueResult();
		return patient;
	}
	
	@Override
	public List<Patient> getAll() {
		List<Patient> patients = emf.unwrap(Session.class).createCriteria(Patient.class).list();
		return patients;
	}
	
	@Override
	public Patient savePatient(Patient patient) {
		emf.persist(patient);
		return patient;
		
	}
	
	
	
	@Override
	public Patient updatePateint(Patient patient) {
		Patient patient1=ht.load(Patient.class, patient.getId());
		 
        if(patient1!=null) {
        	 BeanUtils.copyProperties(patient, patient1);
        	  ht.update(patient1);
        }
		
		return patient1;
	}
	
	
	
	
	@Override
	public List<Appointment> getPatientMedicalHistory(long  id) {
		Criteria criteria = emf.unwrap(Session.class).createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("patient.id", (long) id));
		     criteria.addOrder(Order.desc("created"));       
		List<Appointment>listappointment=criteria.list();
		return listappointment;
	}
	
	
	
	@Override
	public Appointment getPatientMedicalDetailsByID(long id) {
		Appointment appointment=emf.find(Appointment.class, id);
		return appointment;
	}

}
