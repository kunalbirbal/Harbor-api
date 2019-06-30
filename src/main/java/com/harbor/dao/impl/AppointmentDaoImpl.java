package com.harbor.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.harbor.common.Utils;
import com.harbor.dao.IAppointmentDao;
import com.harbor.model.Appointment;
import com.harbor.model.Slot;
import com.harbor.model.TariffRates;

@Repository
@Transactional
public class AppointmentDaoImpl implements IAppointmentDao {

	private static final String UPDATE_APPOINTMENT = "UPDATE appointments set allergies = ?, diagnosis = ?,habits=?,medicines=?,reason_for_visit=?,symptoms=?,visit_type=? where ID=?";

	@PersistenceContext
	private EntityManager emf;

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		emf.persist(appointment);
		return appointment;
	}

	@Override
	public List<Appointment> searchAppointment(Appointment searchCriteria) {

		Criteria criteria = emf.unwrap(Session.class).createCriteria(Appointment.class);
		Criteria c1 = criteria.createCriteria("slot", "slot", JoinType.LEFT_OUTER_JOIN);
		c1.createAlias("slot.doctor", "sltdoc", JoinType.NONE);
		criteria.add(Restrictions.eq("slot.doctor.id", (long) searchCriteria.getDoctor_id()));

		if (null != searchCriteria.getDate()) {
			Date fromDate = searchCriteria.getDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(fromDate);
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);

			fromDate = cal.getTime();

			criteria.add(Restrictions.ge("created", fromDate));
		}

		if (null != searchCriteria.getDate()) {
			Date toDate = searchCriteria.getDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(toDate);
			cal.add(Calendar.HOUR_OF_DAY, 23);
			toDate = cal.getTime();
			criteria.add(Restrictions.le("created", toDate));
		}

		List<Appointment> list = criteria.list();
		return list;
	}

	@Override
	public Appointment findById(long id) {
		Appointment appointment = emf.find(Appointment.class, id);
		return appointment;
	}

	@Override
	public Appointment updateAppointmentById(Appointment appointment) {
		Appointment getappointment = null;
		getappointment = new Appointment();

		getappointment = emf.find(Appointment.class, appointment.getId());

		appointment.setPatient(getappointment.getPatient());
		appointment.setStatus(getappointment.getStatus());
		appointment.setSlot(getappointment.getSlot());
		appointment.setCreated(getappointment.getCreated());
		appointment.setUpdated(getappointment.getUpdated());
		BeanUtils.copyProperties(appointment, getappointment);
		emf.merge(getappointment);
		return getappointment;
	}

	@Override
	public List<TariffRates> getTariffsByAppointment(Appointment appointment) {
		
		Criteria criteria = emf.unwrap(Session.class).createCriteria(TariffRates.class);
		Criteria c1 = criteria.createCriteria("doctor_dept_assoc", "doctor_dept_assoc", JoinType.LEFT_OUTER_JOIN);
		//c1.createAlias("doctor_dept_assoc.doctor", "doctor_dept_assoc_doc", JoinType.NONE);
		criteria.add(Restrictions.eq("doctor_dept_assoc.doctor.id", (long) appointment.getSlot().getDoctor().getId()));
		criteria.add(Restrictions.eq("doctor_dept_assoc.department.id", (long) appointment.getSlot().getDepartment().getId()));
		
		List<TariffRates> list = criteria.list();
		return list;
	}

}
