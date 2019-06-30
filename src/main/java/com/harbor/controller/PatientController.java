package com.harbor.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.ParseException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harbor.common.Constants;
import com.harbor.exception.ApplicationException;
import com.harbor.model.BaseResponseModel;
import com.harbor.model.Patient;
import com.harbor.service.IPatientService;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
public class PatientController extends BaseController {

	@Autowired
	IPatientService patientService;

	@RequestMapping(value = "/patient/create", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> createAppointment(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException, ApplicationException {

		ObjectMapper mapper = new ObjectMapper();
		Patient patientReq = mapper.readValue(requestBody, Patient.class);

		System.out.println(patientReq);
		Patient savedAppointment = patientService.createPatient(patientReq);

		return getResponseModel(savedAppointment, HttpStatus.OK, null);
	}

	@RequestMapping(value = "/patient/edit", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> editDoctor(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException {
		MultipartFile file = null;
		String filename = null;
		InputStream is = null;
		OutputStream os = null;

		ObjectMapper mapper = new ObjectMapper();
		Patient patient = mapper.readValue(requestBody, Patient.class);
		file = patient.getFile();
		filename = file.getOriginalFilename();
		System.out.println(patient);

		try {
			// create OutputStreams pointing to dest files on server machine file system
			os = new FileOutputStream("c:\\uploads\\" + filename);

			// create InputStream representing uploaded files
			is = file.getInputStream();

			// perform file copy operation to complete FileUploading
			IOUtils.copy(is, os);

		}

		catch (IOException ioe) {
			ioe.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// close all stram

			try {
				if (os != null) {
					os.close();
				}
			}

			catch (IOException ioe) {
				ioe.printStackTrace();
			}

			try {
				if (is != null) {
					is.close();
				}
			}

			catch (IOException ise) {
				ise.printStackTrace();
			}
		}
		patient.setPhoto(filename);
		return getResponseModel(patientService.editPatient(patient), HttpStatus.OK, null);
	}

	
	
	@RequestMapping(value = "patient/medicalhistory/{patient_id}/list", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getPatientMedicalHistory(Principal principal,
			@PathVariable("patient_id") long patient_id) {

		System.out.println("patient_id:" + patient_id);

		return getResponseModel(patientService.getPatientMedicalHistory(patient_id), HttpStatus.OK, null);
	}
	
	
	
	@RequestMapping(value = "/patient/medical/{id}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getDoctorList(Principal principal,@PathVariable("id") long id) {

		return getResponseModel(patientService.getPatientAppointmentDetalisByID(id), HttpStatus.OK, null);
	}


	@RequestMapping(value = "/getpatient/{id}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getPatientById(Principal principal,@PathVariable("id") long id) {

		return getResponseModel(patientService.getPatientById(id), HttpStatus.OK, null);
	}
}
