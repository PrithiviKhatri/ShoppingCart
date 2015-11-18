package mum.edu.shoppingcart.service;

import mum.edu.shoppingcart.domain.Customer;

public interface CustomerService {

	public Customer fetchCustomer(String username);

	public void saveCustomer(Customer customer);

}
