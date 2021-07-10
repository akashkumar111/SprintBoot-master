package com.alosha.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			String path = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();

		ExceptionInfo exceptionInfo = new ExceptionInfo(new Date(), ex.getMessage(), ex.toString(), status, path);

		return ResponseEntity.status(status).body(exceptionInfo);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String path = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();

		ExceptionInfo exceptionInfo = new ExceptionInfo(new Date(), ex.getMessage(), ex.toString(), status, path);
		return ResponseEntity.status(status).body(exceptionInfo);
	}

	
	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,WebRequest request)
	{
		String path = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();

		ExceptionInfo exceptionInfo = new ExceptionInfo(new Date(), ex.getMessage(), ex.toString(), HttpStatus.NOT_FOUND, path);
		return ResponseEntity.status( HttpStatus.NOT_FOUND).body(exceptionInfo);
	}
	
	@ExceptionHandler(NullPointerException.class)
	protected ResponseEntity<Object> handleNullPointerException(NullPointerException ex,WebRequest request)
	{
		String path = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
		System.out.println("This is my custom exception for NullPointerException");

		ExceptionInfo exceptionInfo = new ExceptionInfo(new Date(), ex.getMessage(), ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR, path);
		return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionInfo);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex,WebRequest request)
	{
		System.out.println("This is my custom exception for NoSuchElementException");
		String path = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();

		ExceptionInfo exceptionInfo = new ExceptionInfo(new Date(), ex.getMessage(), ex.toString(), HttpStatus.NOT_FOUND, path);
		return ResponseEntity.status( HttpStatus.NOT_FOUND).body(exceptionInfo);
	}
	

}
