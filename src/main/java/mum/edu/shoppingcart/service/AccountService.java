package mum.edu.shoppingcart.service;

import org.springframework.ui.Model;

import mum.edu.shoppingcart.domain.Account;
import mum.edu.shoppingcart.domain.Order;
import mum.edu.shoppingcart.domain.Payment;

public interface AccountService {
	public void saveAccount(Account account, Model model);

	public Order payANDorder(Payment payment, Model model);

}
