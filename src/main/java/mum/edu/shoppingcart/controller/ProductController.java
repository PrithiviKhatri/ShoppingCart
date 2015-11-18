package mum.edu.shoppingcart.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.shoppingcart.domain.Category;
import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.service.CategoryService;
import mum.edu.shoppingcart.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String loadAddCategory(@ModelAttribute("addProduct") Product product, Model model) {
		List<Category> category = categoryService.getCategory();
		// System.out.println(category.size()+"Size of list Category");
		model.addAttribute("category", category);
		return "addProduct";
	}

	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("addProduct") Product product, BindingResult bindingresult,
			Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (bindingresult.hasErrors()) {

			return "addProduct";
		}
		MultipartFile productImage = product.getProductImage();
		 String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				long unixTime = System.currentTimeMillis() / 1000L;
				String productImageName = product.getName() + unixTime + ".png";
				//productImage.transferTo(new File("E:\\images\\" + productImageName));
				productImage.transferTo(new File(rootDirectory+"\\WEB-INF\\resources\\images\\"+productImageName));
				product.setImage(productImageName);
				product.setCoverImage(getImageFromPath(rootDirectory+"\\WEB-INF\\resources\\images\\"+productImageName));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}

		productService.addProduct(product);
		redirectAttributes.addFlashAttribute("product", product);
		Long catId = product.getCategory().getId();
		redirectAttributes.addFlashAttribute("message", "Added successfully.");
		return "redirect:listproduct/" + catId;
	}

	@RequestMapping(value = "/listproduct/{catId}")
	public ModelAndView allProducts(@PathVariable("catId") Long catId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", productService.getProductsById(catId));
		modelAndView.setViewName("listproduct");
		return modelAndView;
	}

	@RequestMapping(value = "/productDetailsAjax/{id}", produces = "application/json; charset=utf-8")
	public @ResponseBody String productDetailsAjax(@PathVariable("id") Long id) {
		Product product = productService.getUniqueProduct(id);
			return product.toString();
	}
	
	private static byte[] getImageFromPath(String path) {
		// save image into database
		File file = new File(path);
		byte[] bFile = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}

}
