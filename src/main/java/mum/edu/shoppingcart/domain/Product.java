package mum.edu.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue
	Long id;

	String productcode;

	String name;

	String description;

	Byte[] image;

	Double unitPrice;

	@ManyToOne
	Category category;

}
