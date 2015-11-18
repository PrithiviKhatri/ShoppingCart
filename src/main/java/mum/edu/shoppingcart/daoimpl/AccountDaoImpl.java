package mum.edu.shoppingcart.daoimpl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.shoppingcart.dao.AccountDao;
import mum.edu.shoppingcart.domain.Account;
import mum.edu.shoppingcart.domain.Customer;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	SessionFactory sessionFactory;

	public void saveAccount(Account account) {

		sessionFactory.getCurrentSession().save(account);
	}

	public Account getAccount(String cardNo) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("select a from Account a where a.cardNo = :cardNo");
		query.setParameter("cardNo", cardNo);
		return (Account) query.list().get(0);
	}

}
