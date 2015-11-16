package mum.edu.shoppingcart.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.shoppingcart.dao.AccountDao;
import mum.edu.shoppingcart.domain.Account;
import mum.edu.shoppingcart.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountdao;

	public Account saveAccount(Account account) {
		
		return accountdao.saveAccount(account);
	}

}
