package mum.edu.shoppingcart.service;

import mum.edu.shoppingcart.domain.LineItem;
import mum.edu.shoppingcart.domain.ShoppingCart;

public interface CartService {
	public LineItem addToCart(String productcode, ShoppingCart cart);

	public void removeFromCart(String productcode, ShoppingCart cart);
}
