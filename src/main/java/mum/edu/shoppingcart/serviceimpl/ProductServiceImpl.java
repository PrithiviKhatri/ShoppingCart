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

}
