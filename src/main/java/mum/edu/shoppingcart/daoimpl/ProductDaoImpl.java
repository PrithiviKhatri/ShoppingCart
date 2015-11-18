package mum.edu.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.shoppingcart.dao.ProductDao;
import mum.edu.shoppingcart.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		return sessionfactory.getCurrentSession().createQuery("from Product").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductsById(Long id) {
		return sessionfactory.getCurrentSession().createQuery("from Product p  where p.category.id="+id).list();
	}

	public void addProduct(Product product) {
		sessionfactory.getCurrentSession().persist(product);
		
	}

	public void deleteProduct(Long ProductId) {
		  Product product =  getProduct(ProductId);
	        if (product != null)
	        	sessionfactory.getCurrentSession().delete(product);
		
	}

	public void editProduct(Product product) {
		sessionfactory.getCurrentSession().update(product);
		
	}

	public Product getProduct(Long productId) {
		Product product = (Product) sessionfactory.getCurrentSession().get(Product.class, productId);
        return product;
	}

}
