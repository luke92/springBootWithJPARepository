package sube.excercises.interviews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sube.excercises.interviews.entities.Product;
import sube.excercises.interviews.entities.TopProduct;


@Repository


public interface ProductRepository extends JpaRepository<Product , Integer> {



	@Query(value=
			 "SELECT PRODUCT.description as productDescription , "
			 + "SUM( SHIPPING_ITEM.product_count) as cantidad "
			 + "FROM PRODUCT INNER JOIN SHIPPING_ITEM on PRODUCT.id = SHIPPING_ITEM.product_id "
			 + "GROUP BY PRODUCT.id "
			 + "ORDER BY SUM( SHIPPING_ITEM.product_count) DESC  "
			 + "LIMIT 3" ,
			 nativeQuery = true)
	public List<TopProduct> ReportsProductsTop();
	

	
}
