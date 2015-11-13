package mum.edu.shoppingcart.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue
	Long id;

	String cardNo;

	String billingAddress;

	String cardtype;

	@OneToMany(mappedBy = "account")
	List<Payment> payments;

	@OneToMany
	List<ShoppingCart> carts;

	@OneToOne
	Customer customer;

}