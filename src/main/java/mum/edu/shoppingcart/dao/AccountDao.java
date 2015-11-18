package mum.edu.shoppingcart.dao;

import mum.edu.shoppingcart.domain.Account;

public interface AccountDao {

	public void saveAccount(Account account);
	public Account getAccount(String cardNo);

}
