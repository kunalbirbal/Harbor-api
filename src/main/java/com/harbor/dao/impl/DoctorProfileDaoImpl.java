package com.harbor.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.harbor.dao.IDoctorProfileDao;
import com.harbor.model.Doctor;

@Repository
@Transactional
public class DoctorProfileDaoImpl implements IDoctorProfileDao {

	
	
	@PersistenceContext
	private EntityManager emf;
	  @Autowired	
      HibernateTemplate ht;
	
	
	@Override
	public Doctor getDoctorByID(long id) {
		Doctor doctor = emf.find(Doctor.class, id);
		return doctor;
	}
	
	@Override
	public Doctor editById(Doctor doctor) {
 //Doctor doctor1=emf.find(Doctor.class,doctor.getId());
		Doctor doctor1=ht.load(Doctor.class, doctor.getId());
		 
                if(doctor1!=null) {
                	 BeanUtils.copyProperties(doctor, doctor1);
                	  ht.update(doctor1);
                }
              
	//     emf.merge(doctor1);
		
		return doctor1;
	}

}
