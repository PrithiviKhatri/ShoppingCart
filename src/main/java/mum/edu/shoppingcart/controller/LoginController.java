package mum.edu.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.service.ProductService;

@Controller
public class LoginController {

	@Autowired
	ProductService productService;

	@RequestMapping("/")
	public String homePage(){
		System.out.println("inside homePage");
		return "home";
		
	}
	
	@ModelAttribute("products")
	public List<Product> getAllproducts(){
		return productService.getAllProducts();
	}
}
