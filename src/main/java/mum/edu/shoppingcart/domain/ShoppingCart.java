package mum.edu.shoppingcart.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue
	Long id;

	Date creationDate;

	@OneToMany
	List<LineItem> items;

}
