package com.harbor.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harbor.common.Constants;
import com.harbor.exception.ApplicationException;
import com.harbor.model.BaseResponseModel;
import com.harbor.model.HospitalPatient;
import com.harbor.service.HospitalPatientService;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
public class HospitalPatientController extends BaseController {

	@Autowired
	HospitalPatientService hospatser;

	@RequestMapping(value = "/hospital-patient/create", method = RequestMethod.POST)
	public ResponseEntity<BaseResponseModel> createPatientVitals(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException, ApplicationException {
		ObjectMapper mapper = new ObjectMapper();
		HospitalPatient hospatient = mapper.readValue(requestBody, HospitalPatient.class);
		System.out.println(hospatient);

		HospitalPatient regHospitalPatient = hospatser.createHospitalPatient(hospatient);

		return getResponseModel(regHospitalPatient, HttpStatus.OK, null);
	}

	@RequestMapping(value = "/hospital-patient/{doctor_id}/list", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getHospitalPatientsByDoctor(Principal principal,
			@PathVariable("doctor_id") int doctorId) {
		
		        System.out.println("doctor:"+doctorId);

		return getResponseModel(hospatser.getHospitalPatientsListByDoctorId(doctorId), HttpStatus.OK, null);
	}
	
	
	
	@RequestMapping(value = "/doctor-patient/{doctor_id}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getDoctorPatientByDoctorId(Principal principal,
			@PathVariable("doctor_id") int doctorId) {
		
		        System.out.println("doctor:"+doctorId);

		return getResponseModel(hospatser.getDoctorPatientById(doctorId), HttpStatus.OK, null);
	}
	
	
	@RequestMapping(value = "/doctor-patient/patient/{patientid}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getAppointmentByPatientId(Principal principal,
			@PathVariable("patientid") long patientid) {
		
		        System.out.println("doctor:"+patientid);

		return getResponseModel(hospatser.getAppointmentDetalisdtByPatientId(patientid), HttpStatus.OK, null);
	}
	
	
	
	@RequestMapping(value = "/doctor-patient/patient/appointment/{appointmentid}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getPatientByAppointmentId(Principal principal,
			@PathVariable("appointmentid") long appointmentid) {
		
		        System.out.println("doctor:"+appointmentid);

		return getResponseModel(hospatser.getPatientByAppointmentId(appointmentid), HttpStatus.OK, null);
	}


}