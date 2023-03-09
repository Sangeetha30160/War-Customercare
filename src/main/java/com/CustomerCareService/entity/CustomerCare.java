package com.CustomerCareService.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customercare")
public class CustomerCare {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerid")
	private Integer customerId;
	
	@Column(name = "customeremail")
	private String customerEmail;
	
	@Column(name = "feedback")
	private String feedback;
	public CustomerCare(Integer customerId, String customerEmail, String feedback) {
		super();
		this.customerId = customerId;
		this.customerEmail = customerEmail;
		this.feedback = feedback;
	}
	public CustomerCare() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "CustomerCare [customerId=" + customerId + ", customerEmail=" + customerEmail + ", feedback=" + feedback
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerEmail, customerId, feedback);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerCare other = (CustomerCare) obj;
		return Objects.equals(customerEmail, other.customerEmail) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(feedback, other.feedback);
	}
	
	
}
