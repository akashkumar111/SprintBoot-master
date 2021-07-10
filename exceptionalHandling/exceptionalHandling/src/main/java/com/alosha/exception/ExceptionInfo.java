package com.alosha.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionInfo {

	private Date date;
	private String error;
	private String message;
	private HttpStatus status;
	private String path;
	
	public ExceptionInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public ExceptionInfo(Date date, String error, String message, HttpStatus status, String path) {
		super();
		this.date = date;
		this.error = error;
		this.message = message;
		this.status = status;
		this.path = path;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
