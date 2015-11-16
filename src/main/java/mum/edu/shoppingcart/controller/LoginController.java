package mum.edu.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.domain.ShoppingCart;
import mum.edu.shoppingcart.service.ProductService;

@Controller
@SessionAttributes({"customer","cart","loginFromCheckout"})
public class LoginController {

	@Autowired
	ProductService productService;

	@ModelAttribute("products")
	public List<Product> getAllproducts() {
		return productService.getAllProducts();
	}

	@RequestMapping("/")
	public String homePage(Model model) {
		System.out.println("inside homePage");
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new ShoppingCart());
		}
		return "home";

	}

	@RequestMapping("/loginsuccess")
	public String loginsuccess(Model model) {
		System.out.println("inside loginsuccess ");
		if (model.containsAttribute("loginFromCheckout")) {

			return "checkout";
		}
		
		return "redirect:/";
	
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		System.out.println("inside login falied");
		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		System.out.println("inside logout");
		status.setComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("inside login method!!!");
		return "login";
	}
}
