package com.CustomerCareService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = FeedbackNotFoundException.class)
	public ResponseEntity<String> feedbackNotFound(FeedbackNotFoundException e) {
		return new ResponseEntity<>("Kindly provide your feedback", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = FeedbackAlreadyExistsException.class)
	public ResponseEntity<String> feedbackAlreadyExists(FeedbackAlreadyExistsException e) {
		return new ResponseEntity<>("Thanks for your Feedback", HttpStatus.FOUND);
	}
}



