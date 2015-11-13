package mum.edu.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue
	Long id;

	Double total;

	String comments;

	@ManyToOne
	Account account;

	@OneToOne(mappedBy="payment")
	Order order;
	
}
