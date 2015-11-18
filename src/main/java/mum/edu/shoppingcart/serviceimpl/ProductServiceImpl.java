package mum.edu.shoppingcart.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.shoppingcart.dao.ProductDao;
import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productdao;

	public List<Product> getAllProducts() {
		return productdao.getAllProducts();
	}

	public void addProduct(Product product) {
		productdao.addProduct(product);
		
	}

	public void deleteProduct(Long productId) {
		productdao.deleteProduct(productId);
		
	}

	public void editProduct(Product product) {
		productdao.editProduct(product);
		
	}

	public Product getUniqueProduct(Long productId) {
		return productdao.getProduct(productId);
	}

	public List<Product> getProductsById(Long id) {
		return productdao.getProductsById(id);
	}
	
	

}
