package mum.edu.shoppingcart.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mum.edu.shoppingcart.dao.CategoryDao;
import mum.edu.shoppingcart.domain.Category;
import mum.edu.shoppingcart.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categorydao;

	public void addCategory(Category category) {
		categorydao.addCategory(category);
	}

	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return categorydao.getAllCategory();
	}

	public void deleteCategory(Long catId) {
		categorydao.deleteCategory(catId);
		
	}

	public void editCategory( Category c) {
		Category category= categorydao.getCategory(c.getId());
		category.setType(c.getType());
		categorydao.editCategory(category);
		}

	public Category getUniqueCategory(Long catId) {
		return categorydao.getCategory(catId);
	}

	

}
