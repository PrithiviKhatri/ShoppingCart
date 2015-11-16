package mum.edu.shoppingcart.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Account implements Serializable {

	@Id
	@GeneratedValue
	Long id;

	public  Account() {
	}

	@NotEmpty
	@Size(min = 8, max = 20, message = "{Size.card.validation}")
	String cardNo;

	@NotEmpty
	String billingAddress;

	@NotEmpty
	String cardtype;

	@OneToMany(mappedBy = "account")
	List<Payment> payments;

	@OneToMany
	List<ShoppingCart> carts;

	@OneToOne
	Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<ShoppingCart> getCarts() {
		return carts;
	}

	public void setCarts(List<ShoppingCart> carts) {
		this.carts = carts;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}