package mum.edu.shoppingcart.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CustomerOrder")
public class Order {

	@Id
	@GeneratedValue
	Long id;

	String shippingAdress;

	Date orderedDate;

	@Enumerated(EnumType.STRING)
	OrderStatus orderstatus;

	@OneToOne
	Payment payment;

	
	
}
