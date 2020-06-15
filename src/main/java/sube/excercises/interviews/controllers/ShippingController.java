package sube.excercises.interviews.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sube.excercises.interviews.entities.Shipping;
import sube.excercises.interviews.responses.AppResponse;
import sube.excercises.interviews.service.ShippingService;

@RestController
@RequestMapping(path = "/shipping")
public class ShippingController {

	@Autowired
	ShippingService shippingService;
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/transition/sendToMail/{shippingId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AppResponse sendtoMailById(@PathVariable Integer shippingId) {
		
		return shippingService.sendToMailById(shippingId);
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/transition/inTravelById/{shippingId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AppResponse inTravelById(@PathVariable Integer shippingId) {
		
		return shippingService.inTravelById(shippingId);
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/transition/deliveredById/{shippingId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AppResponse deliveredById(@PathVariable Integer shippingId) {
		
		return shippingService.deliveredById(shippingId);
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/transition/cancelledById/{shippingId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AppResponse cancelledById(@PathVariable Integer shippingId) {
		
		return shippingService.cancelledById(shippingId);
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/info/{shippingId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Shipping> InfoById(@PathVariable Integer shippingId) {
		
		return shippingService.getInfoById(shippingId);
		
	}
}