package com.CustomerCareService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerCareService.entity.CustomerCare;

public interface CustomerCareDAO extends JpaRepository<CustomerCare, Integer>{

}
