package com.harbor.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.model.BaseResponseModel;
import com.harbor.model.User;


@RestController
@RequestMapping(value = "/api")
public class TestController extends BaseController{
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	ResponseEntity<BaseResponseModel> test(Principal principal) {
		

		return getResponseModel(principal, HttpStatus.OK, "REQUEST SUCCESSFULL.");
	}

}
