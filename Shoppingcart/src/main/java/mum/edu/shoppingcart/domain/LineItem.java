package mum.edu.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LineItem {

	@Id
	@GeneratedValue
	Long id;

	int quanity;

	double totalprice;

	@ManyToOne
	Product product;

}
