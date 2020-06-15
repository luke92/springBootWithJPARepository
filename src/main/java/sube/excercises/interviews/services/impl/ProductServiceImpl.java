package sube.excercises.interviews.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sube.excercises.interviews.entities.Product;
import sube.excercises.interviews.entities.TopProduct;
import sube.excercises.interviews.repository.ProductRepository;
import sube.excercises.interviews.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prepo;

	public List<TopProduct> ReportsProductsTops() {
		List<TopProduct> productsTop = prepo.ReportsProductsTop();
		return productsTop;
	}

}
