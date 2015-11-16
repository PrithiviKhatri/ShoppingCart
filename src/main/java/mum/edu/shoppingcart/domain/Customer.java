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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public WebUser getCredential() {
		return credential;
	}

	public void setCredential(WebUser credential) {
		this.credential = credential;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<ShoppingCart> getCarts() {
		return carts;
	}

	public void setCarts(List<ShoppingCart> carts) {
		this.carts = carts;
	}

}
