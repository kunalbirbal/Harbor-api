package com.harbor.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This will be the common response format
 * 
 * Its not necessary to implement this class with everything. just extend this
 * if required with the particular object
 * 
 * @author vickram
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseModel implements Serializable {
//	@JsonProperty("success")
//	public boolean success = true;
	@JsonProperty("status_code")
	public HttpStatus status_code;

	@JsonProperty("message")
	public String message = null;

	@JsonProperty("response")
	public Object response = null;
	
	@JsonProperty("date_time")
	public String date_time = null;

	
	public HttpStatus getStatus_code() {
		return status_code;
	}

	public void setStatus_code(HttpStatus status_code) {
		this.status_code = status_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	protected String getDate_time() {
		return date_time;
	}

	protected void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
}
