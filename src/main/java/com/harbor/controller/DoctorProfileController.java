package com.harbor.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;

import javax.websocket.server.PathParam;

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
import com.harbor.model.BaseResponseModel;
import com.harbor.model.Doctor;
import com.harbor.model.Slot;
import com.harbor.service.IDoctorProfileService;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
public class DoctorProfileController extends BaseController {
    
	@Autowired
	IDoctorProfileService docservice;
	
	@RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getDoctorList(Principal principal,@PathVariable("id") long id) {

		return getResponseModel(docservice.viewDoctorByID(id), HttpStatus.OK, null);
	}

	@RequestMapping(value = "/doctor/edit", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> editDoctor(Principal principal, @RequestBody String requestBody)
		throws JsonParseException, JsonMappingException, IOException, ParseException {


			ObjectMapper mapper = new ObjectMapper();
			Doctor doctor = mapper.readValue(requestBody, Doctor.class);

			System.out.println(doctor);

			return getResponseModel(docservice.editDoctor(doctor), HttpStatus.OK, null);
		}
	
}
