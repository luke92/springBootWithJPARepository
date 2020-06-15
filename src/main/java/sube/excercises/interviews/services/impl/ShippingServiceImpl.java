package sube.excercises.interviews.services.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sube.excercises.interviews.entities.Shipping;
import sube.excercises.interviews.repository.ShippingRepository;
import sube.excercises.interviews.responses.AppResponse;
import sube.excercises.interviews.service.ShippingService;

@Service
public class ShippingServiceImpl implements ShippingService {

	@Autowired
	ShippingRepository srepo;

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public AppResponse sendToMailById(Integer id) {

		AppResponse response = new AppResponse();
		Optional<Shipping> s = srepo.findById(id);
		if (s.get() == null)

		{
			response.setError("No se encontro un envio del ID: " + id);
		} else {
			if (s.get().getState().toUpperCase().equals(ShippingStates.inicial.toUpperCase())) {
				s.get().setState(ShippingStates.EntregadoAlCorreo);
				s.get().setSend_date(LocalDate.now());
				srepo.save(s.get());

			} else {
				response.setError("No se pudo cambiar al estado " + ShippingStates.enCamino + "porque no estaba "
						+ ShippingStates.EntregadoAlCorreo);
			}

		}
		return response;
	}

	@Override
	public AppResponse inTravelById(Integer id) {

		AppResponse response = new AppResponse();
		Optional<Shipping> s = srepo.findById(id);
		if (s.get() == null)

		{
			response.setError("No se encontro un envio del ID: " + id);
		}

		else {
			if (s.get().getState().toUpperCase().equals(ShippingStates.EntregadoAlCorreo.toUpperCase())) {
				s.get().setState(ShippingStates.enCamino);
				srepo.save(s.get());
			} else {

				response.setError("No se pudo cambiar al estado " + ShippingStates.enCamino + "porque no estaba "
						+ ShippingStates.EntregadoAlCorreo);
			}

		}
		return response;

	}

	@Override
	public AppResponse deliveredById(Integer id) {
		AppResponse response = new AppResponse();
		Optional<Shipping> s = srepo.findById(id);
		if (s.get() == null)

		{
			response.setError("No se encontro un envio del ID: " + id);
		}

		else {

			if (s.get().getState().toUpperCase().equals(ShippingStates.enCamino.toUpperCase())) {
				s.get().setState(ShippingStates.Entregado);
				s.get().setArrive_date(LocalDate.now());
				srepo.save(s.get());
			}

			else {

				response.setError("No se pudo cambiar al estado " + ShippingStates.Entregado + " porque no estaba "
						+ ShippingStates.enCamino);
			}
		}
		return response;

	}

	@Override
	public AppResponse cancelledById(Integer id) {
		AppResponse response = new AppResponse();
		Optional<Shipping> s = srepo.findById(id);
		if (s.get() == null)

		{
			response.setError("No se encontro un envio del ID: " + id);
		} else {
			if (s.get().getState().toUpperCase().equals(ShippingStates.inicial.toUpperCase())
					|| s.get().getState().toUpperCase().equals(ShippingStates.EntregadoAlCorreo.toUpperCase())) {
				s.get().setState(ShippingStates.Cancelado);
				srepo.save(s.get());
			}

			else {
				response.setError("No se pudo cambiar al estado " + ShippingStates.Cancelado + "porque no estaba "
						+ ShippingStates.EntregadoAlCorreo + " Ó " + ShippingStates.inicial);
			}

		}

		return response;

	}

	public Optional<Shipping> getInfoById(Integer id) {
		Optional<Shipping> s = srepo.findById(id);
		return s;

	}
	

}