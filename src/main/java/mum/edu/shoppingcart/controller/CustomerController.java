package mum.edu.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/addCustomer")
	public String addnewCustomer() {
		System.out.println("inside add new customer");
		return "addCustomer";
	}

}
