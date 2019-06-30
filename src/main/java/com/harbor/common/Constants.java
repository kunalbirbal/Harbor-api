package com.harbor.common;

import java.util.LinkedList;

public interface Constants {

	public String API_BASE_URL = "/api";
	public String CORS_AUTHORIZATION_HEADER_TOKEN = "Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtcmNvb2wiLCJ1c2VySWQiOiI5Iiwicm9sZSI6ImFkbWluIn0.YvfUxAwoHSibYxDHZ5ZLyLok5LQ1TvapRqfTQpHZObwK5By3hi_U3Hrqoh371-LOb1MbXgq0hDJwJnABlE93mw";

	interface APPPOINTMENT_STATUSES {
		int AVAILABLE = 0;
		int BOOKED = 1;
		int CLOSED = 2;

	}
	
}


