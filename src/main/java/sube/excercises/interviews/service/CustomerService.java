package sube.excercises.interviews.service;

import org.springframework.stereotype.Service;

import sube.excercises.interviews.entities.Customer;

@Service
public interface CustomerService {
	
	Customer getCustomById(Integer id);

}
