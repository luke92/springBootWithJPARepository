package sube.excercises.interviews.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sube.excercises.interviews.entities.Product;
import sube.excercises.interviews.entities.TopProduct;

@Service


public interface ProductService {
	
	List<TopProduct>  ReportsProductsTops();

}
