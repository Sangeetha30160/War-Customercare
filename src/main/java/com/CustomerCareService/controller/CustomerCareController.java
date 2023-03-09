package com.CustomerCareService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerCareService.entity.CustomerCare;
import com.CustomerCareService.exceptions.FeedbackAlreadyExistsException;
import com.CustomerCareService.exceptions.FeedbackNotFoundException;
import com.CustomerCareService.service.CustomerCareService;

@RestController
public class CustomerCareController {

	
	 
	@Autowired
	private CustomerCareService customerCareService;
    
	@GetMapping("/customercare")
	public List<CustomerCare> getAllFeedback(){
		return this.customerCareService.getAllFeedback();
	}
	
	@GetMapping("/customercare/{customerId}")
	public ResponseEntity<CustomerCare> getFeedbackById(@PathVariable("customerId") Integer customerId) throws FeedbackNotFoundException{
		return new ResponseEntity<CustomerCare>(customerCareService.getFeedbackById(customerId),HttpStatus.OK);
	}
	
	@PostMapping("/customercare")
	public ResponseEntity<String> addFeedback(@RequestBody CustomerCare customerCare) throws FeedbackAlreadyExistsException{
		 this.customerCareService.addFeedback(customerCare);
		 return new ResponseEntity<>("Feedback Added Successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/customercare")
	public ResponseEntity<String> updateFeedback(@RequestBody CustomerCare customerCare) throws FeedbackNotFoundException{
		 this.customerCareService.updateFeedback(customerCare);
		 return new ResponseEntity<>("Feedback Updated Successfully", HttpStatus.OK);
	}
}
