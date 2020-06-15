package sube.excercises.interviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sube.excercises.interviews.entities.Customer;
import sube.excercises.interviews.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomController {

	@Autowired
	CustomerService cService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/info/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomById(@PathVariable Integer customerId)  {

		return cService.getCustomById(customerId);

	}

}
