package com.harbor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.harbor.dao.IDoctorPatientDao;
import com.harbor.model.Appointment;
import com.harbor.model.AppointmentPatients;
import com.harbor.model.HospitalPatient;
import com.harbor.model.Patient;

@Repository
@Transactional
public class HospitalPatientDaoImpl implements IDoctorPatientDao {
	
	private static final String GET_DOCTOR_PATIENT_BY_ID="SELECT DISTINCT a.patient_id, a.slot_id, b.doctor_id, c.name, c.contact FROM appointments a  INNER JOIN  slots b  ON a.slot_id = b.id INNER JOIN  patients c  ON a.patient_id = c.id  WHERE   b.doctor_id = :docid";
	
	@PersistenceContext
	EntityManager emf;
	
	@Autowired
	HibernateTemplate ht;

	@Override
	public HospitalPatient insertHospitalPatient(HospitalPatient hospat) {
		
		emf.persist(hospat);
		
		return hospat;
	}
	
	
	@Override
	public List<HospitalPatient> getHospitalPatientByDoctorId(int doctorid) {
		Criteria criteria = emf.unwrap(Session.class).createCriteria(HospitalPatient.class);
		criteria.add(Restrictions.eq("doctor.id", (long) doctorid));

		List<HospitalPatient> hospitalpatients = criteria.list();
		
		System.out.println(hospitalpatients);
		return hospitalpatients;
	}


	@Override
	public List<AppointmentPatients> getDoctorPatientById(int doctorid) {
		List<AppointmentPatients>doctorpatient=null;
		SQLQuery query=null;
		  Session ses=null;
		  ses=ht.getSessionFactory().getCurrentSession();
		  query = emf.unwrap(Session.class).createSQLQuery(GET_DOCTOR_PATIENT_BY_ID);
		  query.setResultTransformer(Transformers.aliasToBean(AppointmentPatients.class));
		  query.setParameter("docid", doctorid);
		  doctorpatient=query.addScalar("patient_id", StandardBasicTypes.LONG)
				  .addScalar("slot_id", StandardBasicTypes.LONG)
				  .addScalar("doctor_id", StandardBasicTypes.LONG)
				  .addScalar("name", StandardBasicTypes.STRING)
				  .addScalar("contact", StandardBasicTypes.STRING)
				  .list();
		  System.out.println(doctorpatient);
		return doctorpatient;
	}
	
	
	@Override
	public List<Appointment> getAppointmentByPatientId(long patientid) {
		Patient patient=emf.find(Patient.class, patientid);
		
		
		Criteria criteria = emf.unwrap(Session.class).createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("patient.id", (long) patient.getId()));
		criteria.addOrder(Order.desc("created"));
		List<Appointment> appointmentpatient = criteria.list();
		return appointmentpatient;
	}

	
	
	
	@Override
	public Appointment getPatietByAppointmentId(long appointmentid) {
	    Appointment appointment=emf.find(Appointment.class, appointmentid);
		
		
		
		return appointment;
	}
}
