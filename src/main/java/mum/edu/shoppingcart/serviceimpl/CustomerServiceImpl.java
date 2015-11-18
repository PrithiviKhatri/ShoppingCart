package mum.edu.shoppingcart.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mum.edu.shoppingcart.dao.CustomerDao;
import mum.edu.shoppingcart.domain.Customer;
import mum.edu.shoppingcart.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerdao;

	public Customer fetchCustomer(String username) {
		return customerdao.fetchCustomer(username);
	}

	public void saveCustomer(Customer customer) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(customer.getCredential().getPassword());
		customer.getCredential().setPassword(encodedPassword);
		customerdao.saveCustomer(customer);
	}

}
