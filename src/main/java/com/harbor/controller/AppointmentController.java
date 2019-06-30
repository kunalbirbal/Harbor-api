package com.harbor.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harbor.common.Constants;
import com.harbor.exception.ApplicationException;
import com.harbor.model.Appointment;
import com.harbor.model.BaseResponseModel;
import com.harbor.model.Slot;
import com.harbor.service.IAppointmentService;
import com.harbor.service.IDoctorService;
import com.harbor.service.IPatientService;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
public class AppointmentController extends BaseController {

	@Autowired
	IDoctorService doctorService;

	@Autowired
	IPatientService patientService;
	
	

	@Autowired
	IAppointmentService appointmentService;

	@RequestMapping(value = "/doctor/list", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getDoctorList(Principal principal) {

		return getResponseModel(doctorService.getDoctorList(), HttpStatus.OK, null);
	}
	
	@RequestMapping(value = "/appointment/{appointmentId}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getAppointmentById(Principal principal, @PathVariable("appointmentId") long appointmentId) {

		return getResponseModel(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK, null);
	}

	@RequestMapping(value = "/doctor/{doctorId}/departments", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getDepartmentsByDoctor(Principal principal,
			@PathVariable("doctorId") int doctorId) {

		return getResponseModel(doctorService.getDepartmentListByDoctorId(doctorId), HttpStatus.OK, null);
	}

	@RequestMapping(value = "/doctor/slots", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> getDepartmentsByDoctor(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		ObjectMapper mapper = new ObjectMapper();
		Slot slot = mapper.readValue(requestBody, Slot.class);

		System.out.println(slot);

		return getResponseModel(doctorService.getSlotsByDoctorIdAndDepartmentId(slot.getDoctor_id(),
				slot.getDepartment_id(), slot.getDate()), HttpStatus.OK, null);
	}

	@RequestMapping(value = "/patient/mobile/{mobile}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getPatientByMobile(Principal principal, @PathVariable("mobile") String mobile) {

		return getResponseModel(patientService.getPatientByMobile(mobile), HttpStatus.OK, null);
	}

	@RequestMapping(value = "/appointment/create", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> createAppointment(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException, ApplicationException {

		ObjectMapper mapper = new ObjectMapper();
		Appointment appointmentReq = mapper.readValue(requestBody, Appointment.class);

		System.out.println(appointmentReq);
		Appointment savedAppointment = appointmentService.createAppointment(appointmentReq);

		return getResponseModel(savedAppointment, HttpStatus.OK, null);
	}

	@RequestMapping(value = "/appointment/search", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> searchAppointment(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException, ApplicationException {

		ObjectMapper mapper = new ObjectMapper();
		Appointment appointmentReq = mapper.readValue(requestBody, Appointment.class);

		System.out.println(appointmentReq);
		List<Appointment> appointmentList = appointmentService.searchAppointment(appointmentReq);

		return getResponseModel(appointmentList, HttpStatus.OK, null);
	}

	@RequestMapping(value = "/appointment/update", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> updateAppointment(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException, ApplicationException {

		ObjectMapper mapper = new ObjectMapper();
		Appointment appointmentReq = mapper.readValue(requestBody, Appointment.class);

		System.out.println(appointmentReq);
		if (appointmentReq != null) {
			Appointment savedAppointment = appointmentService.updateAppointment(appointmentReq);

			return getResponseModel(savedAppointment, HttpStatus.OK, null);
		}
		Appointment savedAppointment = appointmentService.updateApp(appointmentReq);

		return getResponseModel(savedAppointment, HttpStatus.OK, null);
	}
	
	@RequestMapping(value = "/appointment/detail/update", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> updatePatientMedicalDetail(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException, ApplicationException {

		ObjectMapper mapper = new ObjectMapper();
		Appointment appointmentReq = mapper.readValue(requestBody, Appointment.class);

		System.out.println(appointmentReq);
		
		Appointment savedAppointment = appointmentService.updateApp(appointmentReq);

		return getResponseModel(savedAppointment, HttpStatus.OK, null);
	}

	@RequestMapping(value = "/tariffs/appointment/{appointmentId}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getTariffsByAppointment(Principal principal,
			@PathVariable("appointmentId") long appointmentId) {

		return getResponseModel(appointmentService.getTariffsByAppointmentId(appointmentId), HttpStatus.OK, null);
	}

}
