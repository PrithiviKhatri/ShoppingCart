package mum.edu.shoppingcart.dao;

import java.util.List;

import mum.edu.shoppingcart.domain.Product;

public interface ProductDao {

	public List<Product> getAllProducts();

	public Product getProduct(String productcode);
}
