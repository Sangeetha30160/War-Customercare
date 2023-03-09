package com.CustomerCareService.service;

import java.util.List;

import com.CustomerCareService.entity.CustomerCare;
import com.CustomerCareService.exceptions.FeedbackAlreadyExistsException;
import com.CustomerCareService.exceptions.FeedbackNotFoundException;

public interface CustomerCareService {
	
	public List<CustomerCare> getAllFeedback();

	public CustomerCare addFeedback(CustomerCare customercare) throws FeedbackAlreadyExistsException;

	public CustomerCare updateFeedback(CustomerCare customercare) throws FeedbackNotFoundException;

	public CustomerCare getFeedbackById(Integer customerId) throws FeedbackNotFoundException;

	public void deleteFeedbackById(Integer customerId) throws FeedbackNotFoundException;

}
