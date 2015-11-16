package mum.edu.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.shoppingcart.dao.ProductDao;
import mum.edu.shoppingcart.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionfactory;

	public List<Product> getAllProducts() {
		return sessionfactory.getCurrentSession().createQuery("from Product").list();
	}

	public Product getProduct(String productcode) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("select p from Product p where p.productcode = :productcode");
		query.setParameter("productcode", productcode);
		List<Product> products=query.list();
		return (Product) query.list().get(0);
	}
}
