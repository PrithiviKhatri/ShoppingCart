package mum.edu.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.shoppingcart.dao.CategoryDao;
import mum.edu.shoppingcart.domain.Category;
import mum.edu.shoppingcart.domain.Product;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionfactory;
	
	public void addCategory(Category category) {
		sessionfactory.getCurrentSession().save(category);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		return sessionfactory.getCurrentSession().createQuery("from Category").list();
	}
	
	
	public Category getCategory(Long catId){
		Category category = (Category) sessionfactory.getCurrentSession().get(Category.class, catId);
		        return category;
	}
	
	public void deleteCategory(Long catId) {
		        Category category = getCategory(catId);
		        if (category != null)
		        	sessionfactory.getCurrentSession().delete(category);
		    }
	
	public void editCategory(Category category){
					sessionfactory.getCurrentSession().update(category);
			     }

}
