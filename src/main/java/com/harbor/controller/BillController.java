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
import com.harbor.model.BaseResponseModel;
import com.harbor.model.Bill;
import com.harbor.model.Slot;
import com.harbor.service.IBillService;


@RestController
@RequestMapping(value = Constants.API_BASE_URL)
public class BillController extends BaseController{
	
	@Autowired
	IBillService billService;

	
	@RequestMapping(value = "/bill/create", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> createBill(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		ObjectMapper mapper = new ObjectMapper();
		Bill req = mapper.readValue(requestBody, Bill.class);

		System.out.println(req);

		return getResponseModel(billService.createBill(req), HttpStatus.OK, null);
	}
	
	@RequestMapping(value = "/bill/search", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> billSearch(Principal principal, @RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		ObjectMapper mapper = new ObjectMapper();
		Bill req = mapper.readValue(requestBody, Bill.class);

		System.out.println(req);

		return getResponseModel(billService.searchBill(req), HttpStatus.OK, null);
	}
	
	@RequestMapping(value = "/bill/{billId}", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> getBill(Principal principal, @PathVariable("billId") long billId) {

		

		return getResponseModel(billService.getBillById(billId), HttpStatus.OK, null);
	}
}
