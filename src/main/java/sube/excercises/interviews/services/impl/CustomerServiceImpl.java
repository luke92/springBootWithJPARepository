package sube.excercises.interviews.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sube.excercises.interviews.entities.Customer;
import sube.excercises.interviews.repository.CustomerRepository;
import sube.excercises.interviews.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository cRepo;

	public static final ModelMapper modelMapper = new ModelMapper();

	public Customer getCustomById(Integer id) {
		return cRepo.findById(id).get();
	}


	}

