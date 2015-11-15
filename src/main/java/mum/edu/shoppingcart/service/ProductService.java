package mum.edu.shoppingcart.service;

import java.util.List;

import mum.edu.shoppingcart.domain.LineItem;
import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.domain.ShoppingCart;

public interface ProductService {
	public List<Product> getAllProducts();

	public Product getProduct(String productcode);

	
}
