package mum.edu.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/carts")
@SessionAttributes("carts")
public class CartController {

	@RequestMapping("/carts/{id}")
	public String addToCart() {
		System.out.println("inside add to cart");

		return "cartDetails";

	}
	/*@RequestMapping(value="/cars/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("car", carDao.get(id));
		return "carDetail";
	}*/
	
}
