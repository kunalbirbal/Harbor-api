package com.harbor.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.common.Constants;
import com.harbor.dao.IAppointmentDao;
import com.harbor.dao.IPatientDao;
import com.harbor.dao.ISlotDao;
import com.harbor.exception.ApplicationException;
import com.harbor.model.Appointment;
import com.harbor.model.Patient;
import com.harbor.model.Slot;
import com.harbor.model.TariffRates;
import com.harbor.service.IAppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	ISlotDao slotDao;

	@Autowired
	IAppointmentDao appointmentDao;

	@Autowired
	IPatientDao patientDao;

	@Override
	public Appointment createAppointment(Appointment req) throws ApplicationException {
		Appointment newRecord = new Appointment();

		Slot slot = slotDao.findById(req.getSlot_id());

		if (slot != null && slot.getStatus() != Constants.APPPOINTMENT_STATUSES.AVAILABLE) {
			throw new ApplicationException(108, "Slot Already booked");
		}

		newRecord.setSlot(slot);

		Patient patient = patientDao.findByMobile(req.getMobile());

		if (patient == null) {
			Patient newPatient = new Patient();
			newPatient.setGender(1);
			newPatient.setAge(0);
			newPatient.setContact(req.getMobile());
			newPatient.setName(req.getPatient_name());
			newPatient.setCreated(new Date());
			newPatient.setUpdated(new Date());
			Patient savedPatient = patientDao.savePatient(newPatient);

			if (savedPatient != null)
				newRecord.setPatient(savedPatient);

		} else {
			newRecord.setPatient(patient);
		}

		newRecord.setStatus(Constants.APPPOINTMENT_STATUSES.BOOKED);
		newRecord.setCreated(new Date());
		newRecord.setUpdated(new Date());

		Appointment savedAppointment = appointmentDao.saveAppointment(newRecord);

		if (savedAppointment != null) {
			slot.setStatus(Constants.APPPOINTMENT_STATUSES.BOOKED);
			slotDao.saveSlot(slot);
		}

		return savedAppointment;
	}

	@Override
	public Appointment updateAppointment(Appointment req) {
		
		 
		Appointment savedAppointment = appointmentDao.findById((long) req.getId());
		
		  System.out.println("id::::"+req.getId());
		savedAppointment.setStatus(req.getStatus());
		appointmentDao.saveAppointment(savedAppointment);
		return savedAppointment;
	}

	@Override
	public List<Appointment> searchAppointment(Appointment req) {
		return appointmentDao.searchAppointment(req);
	}
	
	@Override
	public Appointment getAppointmentById(long appointmentId) {
		return appointmentDao.findById(appointmentId);
	}

	
	
	@Override
	public Appointment updateApp(Appointment appointment) {
	
		return appointmentDao.updateAppointmentById(appointment);
	}
	
	@Override
	public List<TariffRates> getTariffsByAppointmentId(long appointmentId) {
		Appointment savedAppointment = appointmentDao.findById( appointmentId);
		
		return appointmentDao.getTariffsByAppointment(savedAppointment);
	}
	
}
