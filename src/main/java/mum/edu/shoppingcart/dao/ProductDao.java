package mum.edu.shoppingcart.dao;

import java.util.List;


import mum.edu.shoppingcart.domain.Product;

public interface ProductDao   {

public List<Product> getAllProducts();

public void addProduct(Product product);
public void deleteProduct(Long ProductId);
public void editProduct(Product product);
public Product getProduct(Long productId);

public List<Product> getProductsById(Long id);
}
