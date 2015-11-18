package mum.edu.shoppingcart.daoimpl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.shoppingcart.dao.CustomerDao;
import mum.edu.shoppingcart.domain.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionfactory;

	public Customer fetchCustomer(String username) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("select c from Customer c where c.credential.username = :username");
		query.setParameter("username", username);
		return (Customer) query.list().get(0);

	}

	public void saveCustomer(Customer customer) {
		System.out.println("inside save customer");
		sessionfactory.getCurrentSession().save(customer);

	}

}
