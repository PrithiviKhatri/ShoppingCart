package mum.edu.shoppingcart.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	Long id;

	String firstName;

	String lastName;

	Date dateOfBirth;

	String emailAdress;

	String address;

	@OneToOne
	WebUser credential;

	@OneToOne(mappedBy = "customer")
	Account account;

	@OneToMany
	List<ShoppingCart> carts;

}
