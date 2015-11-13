package mum.edu.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WebUser {

	@Id
	@GeneratedValue
	Long id;
	String username;

	String password;

	String role;

}
