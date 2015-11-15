package mum.edu.shoppingcart.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.shoppingcart.domain.LineItem;
import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.domain.ShoppingCart;
import mum.edu.shoppingcart.service.CartService;
import mum.edu.shoppingcart.service.ProductService;

@Controller
@RequestMapping("/carts")
@SessionAttributes("cart")
public class CartController {

	@Autowired
	ProductService productservice;
	
	@Autowired
	CartService cartservice;

	@RequestMapping(value = "/add/{productcode}")
	public String addToCart(@PathVariable String productcode, @ModelAttribute("cart") ShoppingCart cart) {
		System.out.println("inside add to cart");
		LineItem lineitem = cartservice.addToCart(productcode, cart);
		System.out.println("product is " + lineitem);

		return "redirect:/";

	}

	@RequestMapping("/remove/{productcode}")
	public String removeFromCart(@PathVariable String productcode, @ModelAttribute("cart") ShoppingCart cart) {
		System.out.println("inside remove from cart");
		cartservice.removeFromCart(productcode, cart);
		return "redirect:/";

	}

}
