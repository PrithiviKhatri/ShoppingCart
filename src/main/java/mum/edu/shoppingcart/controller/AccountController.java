package mum.edu.shoppingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.shoppingcart.domain.Account;
import mum.edu.shoppingcart.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountservice;

	// @Valid - but NO BindResult! an exception will be thrown...
	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public @ResponseBody Account saveAccount( @RequestBody Account account) {
		System.out.println("inside save Account");
		accountservice.saveAccount(account);
		
		return account;
	}

	

}
