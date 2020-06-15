package sube.excercises.interviews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sube.excercises.interviews.entities.Product;
import sube.excercises.interviews.entities.TopProduct;
import sube.excercises.interviews.service.ProductService;

@RestController
@RequestMapping(path= "/reports")
public class ProductController {

	@Autowired
	ProductService pService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/topSended", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TopProduct> reportsTopSended(){
		
		return pService.ReportsProductsTops();
	}
	
	
}
