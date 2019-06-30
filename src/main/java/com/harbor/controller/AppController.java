package com.harbor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.model.BaseResponseModel;
import com.harbor.model.User;
import com.harbor.security.JwtGenerator;
import com.harbor.service.IUserService;

@RestController
@RequestMapping(value = "/app")
public class AppController extends BaseController {

	@Autowired
	private IUserService userService;

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> login(@RequestBody final User user) {
		User saveduser = userService.login(user);

		if (null != saveduser)
			return getResponseModel(saveduser, HttpStatus.OK, "Login successfull.");

		return getResponseModel(null, HttpStatus.INTERNAL_SERVER_ERROR, "Sorry! invalid credentials.");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	ResponseEntity<BaseResponseModel> signup(@RequestBody final User user) {

		User saveduser = userService.signup(user);

		if (null != saveduser)
			return getResponseModel(saveduser, HttpStatus.OK, "Signup successfull.");

		return getResponseModel(null, HttpStatus.INTERNAL_SERVER_ERROR, "Sorry something went wrong.");

	}

}
