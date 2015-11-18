package mum.edu.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.shoppingcart.domain.Customer;

@Controller
@RequestMapping("/customer")
@SessionAttributes({ "cart", "customer" })
public class CustomerController {

	@RequestMapping("/addCustomer")
	public String addnewCustomer() {
		System.out.println("inside add new customer");
		return "addCustomer";
	}

	@RequestMapping()
public Customer getCustomer(String username){
	
		return null;
}

}
