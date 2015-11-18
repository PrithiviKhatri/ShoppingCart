package mum.edu.shoppingcart.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import mum.edu.shoppingcart.dao.AccountDao;
import mum.edu.shoppingcart.domain.Account;
import mum.edu.shoppingcart.domain.Customer;
import mum.edu.shoppingcart.domain.LineItem;
import mum.edu.shoppingcart.domain.Order;
import mum.edu.shoppingcart.domain.OrderStatus;
import mum.edu.shoppingcart.domain.Payment;
import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.domain.ShoppingCart;
import mum.edu.shoppingcart.service.AccountService;
import mum.edu.shoppingcart.service.ProductService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountdao;
	@Autowired
	ProductService productservice;

	public void saveAccount(Account account, Model model) {
		Customer customer = (Customer) model.asMap().get("customer");
		customer.setAccount(account);
		model.addAttribute(customer);
		account.setCustomer(customer);
		accountdao.saveAccount(account);
	}

	public Order payANDorder(Payment payment, Model model) {
		Customer customer = (Customer) model.asMap().get("customer");
		// Account account = customer.getAccount();

		Account account = accountdao.getAccount(customer.getAccount().getCardNo());
		ShoppingCart cart = (ShoppingCart) model.asMap().get("cart");

		// To update the quanity of the product in DB which are sold
		for (LineItem item : cart.getItems()) {
			Product product = productservice.getProduct(item.getProduct().getProductcode());
			product.setQuantity(product.getQuantity() - item.getQuanity());
			// productservice.
		}

		payment.setTotal(cart.getTotalamout());
		payment.setAccount(account);

		Order order = new Order();
		order.setOrderstatus(OrderStatus.NEW);
		order.setShippingAdress(customer.getAddress());
		order.setPayment(payment);
		payment.setOrder(order);
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(payment);
		account.setPayments(payments);
		List<ShoppingCart> carts = new ArrayList<ShoppingCart>();
		carts.add(cart);
		account.setCarts(carts);
		accountdao.saveAccount(account);
		System.out.println("account saved succesfully");
		return order;
	}

}
