package sube.excercises.interviews.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "SHIPPING")
public class Shipping {

	// send_date DATE, -- java.time.LocalDate
	@Id
	@Column(name = "id")
	private Integer  id;
	
	@Column(name = "state") 
    private String  state ;
	
	@Column(name = "send_date")
    private LocalDate send_date ; // -- java.time.LocalDate
	
	@Column(name = "arrive_date")
	private LocalDate arrive_date; // DATE,
	
	@Column(name = "priority")
    private Integer priority ;
		    
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
	//private Integer customer_id ;
    
	
	@OneToMany(mappedBy="shipping")
	private List<Shipping_item> items;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDate getSend_date() {
		return send_date;
	}

	public void setSend_date(LocalDate send_date) {
		this.send_date = send_date;
	}

	public LocalDate getArrive_date() {
		return arrive_date;
	}

	public void setArrive_date(LocalDate arrive_date) {
		this.arrive_date = arrive_date;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}	
}
