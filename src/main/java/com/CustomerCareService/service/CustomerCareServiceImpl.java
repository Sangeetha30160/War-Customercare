package com.CustomerCareService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerCareService.dao.CustomerCareDAO;
import com.CustomerCareService.entity.CustomerCare;
import com.CustomerCareService.exceptions.FeedbackAlreadyExistsException;
import com.CustomerCareService.exceptions.FeedbackNotFoundException;



	
	@Service
	public class CustomerCareServiceImpl implements CustomerCareService{
		@Autowired
		private CustomerCareDAO customercareDao;

		@Override
		public List<CustomerCare> getAllFeedback() {
			return customercareDao.findAll();
		}

		@Override
		public CustomerCare addFeedback(CustomerCare customercare) throws FeedbackAlreadyExistsException {
			if (customercareDao.findById(customercare.getCustomerId()).isEmpty()) {
				customercareDao.save(customercare);
				return customercare;
				}
				else {
					throw new FeedbackAlreadyExistsException();
				}
		}

		@Override
		public CustomerCare updateFeedback(CustomerCare customercare) throws FeedbackNotFoundException {
			if(customercareDao.findById(customercare.getCustomerId()).isEmpty()) {
				throw new FeedbackNotFoundException();
			}
			else {
			customercareDao.save(customercare);
			return customercare;
			}
		}

		@Override
		public CustomerCare getFeedbackById(Integer customerId) throws FeedbackNotFoundException {
			CustomerCare cc;
			if(customercareDao.findById(customerId).isEmpty()) {
				throw new FeedbackNotFoundException();
			}
			else {
				cc=customercareDao.findById(customerId).get();
			}
			return cc;
		}

		@Override
		public void deleteFeedbackById(Integer customerId) throws FeedbackNotFoundException{
			if(customercareDao.findById(customerId).isEmpty()) {
				throw new FeedbackNotFoundException();
			}
			else {
			 customercareDao.deleteAll();
			}
			
		}
		
	}


