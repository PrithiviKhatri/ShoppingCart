package mum.edu.shoppingcart.dao;

import java.util.List;

import mum.edu.shoppingcart.domain.Category;

public interface CategoryDao {
	public void addCategory(Category category);
	public List<Category> getAllCategory();
	public void deleteCategory(Long catId);
	public Category getCategory(Long catId);
	public void editCategory(Category category);
	
	


}
