package com.harbor.dao;

import java.util.List;

import com.harbor.model.Appointment;
import com.harbor.model.Slot;
import com.harbor.model.TariffRates;

public interface IAppointmentDao {

	Appointment saveAppointment(Appointment appointment);

	List<Appointment> searchAppointment(Appointment criteria);

	Appointment findById(long id);
	
	Appointment updateAppointmentById(Appointment appointment);

	List<TariffRates> getTariffsByAppointment(Appointment appointmentId);

}
