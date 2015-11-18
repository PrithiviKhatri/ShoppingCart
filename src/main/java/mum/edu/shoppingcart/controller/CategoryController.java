package mum.edu.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.shoppingcart.domain.Category;
import mum.edu.shoppingcart.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired 
	CategoryService categoryService;
	
	@RequestMapping(value="/addCategory", method=RequestMethod.GET)
	public String loadAddCategory(@ModelAttribute("addCategory") Category category){
		return "addCategory";
	}
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("addCategory") Category category,BindingResult bindingresult,
			Model model, RedirectAttributes redirectAttributes){
		if(bindingresult.hasErrors()){
			return "addCategory";
		}
		categoryService.addCategory(category);
		redirectAttributes.addFlashAttribute("message", "Product Category has Been added successfully.");
		return "redirect:listCategory";
	}
	
	@RequestMapping(value="/listCategory", method=RequestMethod.GET)
	public String listCategory(Model model){
		List<Category> listcategory=categoryService.getCategory();
		model.addAttribute("listcategory",listcategory);
		return "listCategory";
	}
	
	@RequestMapping(value="/deleteCategory/{catId}", method=RequestMethod.GET)
	public String deleteCategory(@PathVariable("catId") Long catId){
		categoryService.deleteCategory(catId);
		
		return "redirect:/admin/listCategory";
	}
	
	@RequestMapping(value="/editCategory/{catId}", method=RequestMethod.GET)
	public String redirectEditCategory(@PathVariable("catId") Long catId,Model model,RedirectAttributes redirectAttributes){
		Category category=categoryService.getUniqueCategory(catId);
		redirectAttributes.addFlashAttribute(category);
		return "redirect:/admin/editCategory";
	}
	
	@RequestMapping(value="/editCategory", method=RequestMethod.GET)
	public String loadEditCategory(@ModelAttribute("editCategory") Category category){
		return "editCategory";
	}
	
	@RequestMapping(value="/editCategory", method=RequestMethod.POST)
	public String editCategory(@ModelAttribute("editCategory") Category category){
		categoryService.editCategory(category);
		return "redirect:/admin/listCategory";
	}
	

}
