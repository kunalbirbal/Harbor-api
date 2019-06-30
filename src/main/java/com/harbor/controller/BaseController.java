package com.harbor.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.harbor.model.BaseResponseModel;

public class BaseController {

	public ResponseEntity<BaseResponseModel> getResponseModel(Object responseObject, HttpStatus statusCode, String msgText) {
		BaseResponseModel baseResponseModel = new BaseResponseModel();
		baseResponseModel.setResponse(responseObject);
		baseResponseModel.setMessage(msgText);
		baseResponseModel.setStatus_code(statusCode);
		// return baseResponseModel;

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		return new ResponseEntity<BaseResponseModel>(baseResponseModel, responseHeaders, statusCode);
	}

}
