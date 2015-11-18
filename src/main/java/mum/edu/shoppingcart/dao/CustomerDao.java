package mum.edu.shoppingcart.dao;

import mum.edu.shoppingcart.domain.Customer;

public interface CustomerDao {

	public Customer fetchCustomer(String username);
}
