package mum.edu.shoppingcart.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account implements Serializable {

	@Id
	@GeneratedValue
	Long id;

	public Account() {
	}

	@NotEmpty
	@Size(min = 8, max = 20, message = "{Size.card.validation}")
	String cardNo;

	@NotEmpty
	String cardtype;
	@NotEmpty
	String billingAddress;

	@JsonIgnore 
	@OneToMany(mappedBy = "account",cascade=CascadeType.ALL)
	List<Payment> payments=new ArrayList<Payment>();

	@JsonIgnore 
	@OneToMany(cascade=CascadeType.ALL)
	List<ShoppingCart> carts=new ArrayList<ShoppingCart>();

	@JsonIgnore 
	@OneToOne(cascade=CascadeType.ALL)
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

	@Override
	public String toString() {
		return "Account [cardNo=" + cardNo + ", cardtype=" + cardtype + ", billingAddress=" + billingAddress + "]";
	}

}