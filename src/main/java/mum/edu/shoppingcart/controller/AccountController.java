package mum.edu.shoppingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.shoppingcart.domain.Account;
import mum.edu.shoppingcart.domain.Order;
import mum.edu.shoppingcart.domain.Payment;
import mum.edu.shoppingcart.service.AccountService;

@Controller
@RequestMapping("/account")
@SessionAttributes({ "cart", "customer" })
public class AccountController {

	@Autowired
	AccountService accountservice;

	// @Valid - but NO BindResult! an exception will be thrown...
	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public @ResponseBody Account saveAccount(@Valid @RequestBody Account account, Model model) {
		System.out.println("inside save Account");
		// To be added ::Calls the credit card webservice to verify if the
		// account exists and is active

		accountservice.saveAccount(account, model);
		return account;
	}

	@RequestMapping(value = "/checkoutStep3Payment", method = RequestMethod.POST)
	public String checkoutStep3Payment(Payment payment, Model model, RedirectAttributes redir) {
		System.out.println("payment is " + payment);
		System.out.println("inside checkoutStep3 Payment");
		// TO be added :::Calls the Credit card webservice to deduct the payment
		// amount.If amount is
		// not available
		// ,this situation should be handled accordingly

		Order order = accountservice.payANDorder(payment, model);
		redir.addFlashAttribute(order);
		return "redirect:/account/orderDetails";
	}

	@RequestMapping("orderDetails")
	public String showOrderDetails() {
		System.out.println("inside showorderDetails");
		return "orderDetails";
	}

}
