package mum.edu.shoppingcart.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	Long id;

	String type;

	@OneToMany(mappedBy = "category")
	List<Product> products;
}
