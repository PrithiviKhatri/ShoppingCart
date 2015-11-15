package mum.edu.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.domain.ShoppingCart;
import mum.edu.shoppingcart.service.ProductService;

@Controller
@SessionAttributes("cart")
public class LoginController {

	@Autowired
	ProductService productService;

	@RequestMapping("/")
	public String homePage(Model model){
		System.out.println("inside homePage");
		if(!model.containsAttribute("cart")) {
		      model.addAttribute("cart", new ShoppingCart());
		    }
		return "home";
		
	}
	
	@ModelAttribute("products")
	public List<Product> getAllproducts(){
		return productService.getAllProducts();
	}
}
