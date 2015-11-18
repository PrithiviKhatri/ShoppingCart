package mum.edu.shoppingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.shoppingcart.dao.CustomerDao;
import mum.edu.shoppingcart.domain.Customer;
import mum.edu.shoppingcart.service.CustomerService;

@Controller
@RequestMapping("/customer")
@SessionAttributes({ "cart", "customer" })
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@RequestMapping("/addCustomer")
	public String addnewCustomer(@ModelAttribute("newCustomer") Customer customer) {
		System.out.println("inside add new customer");
		return "addCustomer";
	}

	@RequestMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult) {
		System.out.println("inside saveCustomer");
		if (bindingResult.hasErrors()) {
			System.out.println("inside binding result error");
			return "addCustomer";
		}
		customerservice.saveCustomer(customer);
		return "redirect:/";
	}

}
