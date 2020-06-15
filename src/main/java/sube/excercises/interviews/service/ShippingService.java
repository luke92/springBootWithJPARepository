package sube.excercises.interviews.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import sube.excercises.interviews.entities.Shipping;
import sube.excercises.interviews.responses.AppResponse;

@Service
public interface ShippingService {

	AppResponse sendToMailById(Integer id);

	AppResponse inTravelById(Integer id);

	AppResponse deliveredById(Integer id);

	AppResponse cancelledById(Integer id);

	Optional<Shipping> getInfoById(Integer id);
	

}