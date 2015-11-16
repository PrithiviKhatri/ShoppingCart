package mum.edu.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.shoppingcart.domain.LineItem;
import mum.edu.shoppingcart.domain.ShoppingCart;
import mum.edu.shoppingcart.service.CartService;
import mum.edu.shoppingcart.service.ProductService;

@Controller
@RequestMapping("/carts")
@SessionAttributes({ "cart", "customer", "loginFromCheckout" })
public class CartController {

	@Autowired
	ProductService productservice;

	@Autowired
	CartService cartservice;

	@RequestMapping(value = "/add/{productcode}")
	public String addToCart(@PathVariable String productcode, @ModelAttribute("cart") ShoppingCart cart) {
		System.out.println("inside add to cart");
		LineItem lineitem = cartservice.addToCart(productcode, cart);

		return "redirect:/";

	}

	@RequestMapping("/remove/{productcode}")
	public String removeFromCart(@PathVariable String productcode, @ModelAttribute("cart") ShoppingCart cart) {
		System.out.println("inside remove from cart");
		cartservice.removeFromCart(productcode, cart);
		return "redirect:/";

	}

	@RequestMapping("/checkout")
	public String checkoutToPayment(@ModelAttribute("cart") ShoppingCart shoppingcart, Model model) {
		System.out.println("inside checkout to payment");
		if (!model.containsAttribute("customer")) {

			model.addAttribute("loginFromCheckout", true);
			return "login";
		}

		System.out.println("cart is " + shoppingcart);
		return "checkout";
	}

	
	@RequestMapping(value="/checkoutStep2")
	public String checkoutStep2() {
		System.out.println("inside checkout Step2 ");

		return "checkoutStep2";
	}


	@RequestMapping(value="/checkoutStep3")
	public String checkoutStep3() {
		System.out.println("inside checkout Step3 ");

		return "checkoutStep3";
	}
}
