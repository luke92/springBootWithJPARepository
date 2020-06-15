package sube.excercises.interviews.repository;

import java.util.Optional;

//import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import sube.excercises.interviews.entities.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping , Integer> {

	Optional<Shipping> findById(Integer id);
	
	
	

}

