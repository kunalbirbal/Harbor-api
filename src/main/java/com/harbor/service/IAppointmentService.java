package com.harbor.service;

import java.util.List;

import com.harbor.exception.ApplicationException;
import com.harbor.model.Appointment;
import com.harbor.model.TariffRates;

public interface IAppointmentService {

	Appointment createAppointment(Appointment req) throws ApplicationException;

	List<Appointment> searchAppointment(Appointment req);

	Appointment updateAppointment(Appointment req);
	
	Appointment updateApp(Appointment appointment);


	List<TariffRates> getTariffsByAppointmentId(long appointmentId);

	Appointment getAppointmentById(long appointmentId);
}
