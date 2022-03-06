package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ProductController {
	@Autowired
	ProductRepositoryImpl prodRepoImpl;

	@PostMapping("insertProduct")
	public RedirectView insertProduct(@ModelAttribute("product") Product product) {
		prodRepoImpl.saveProduct(product);
		return new RedirectView("/home?getProducts");

	}

	@GetMapping("getProducts")
	public List<Product> getProducts() {
		return prodRepoImpl.getAllProducts();

	}

	@GetMapping("getProductById")
	public Product getProductById(@RequestParam(value = "productId") int productId) {
		return prodRepoImpl.getProductById(productId);

	}

	@RequestMapping(value = "/deleteProd", method = RequestMethod.POST)
	public RedirectView deleteProduct(@ModelAttribute("product") Product product) {
		prodRepoImpl.deleteProduct(product);
		return new RedirectView("/home?getProducts");

	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public RedirectView updateProduct(@ModelAttribute Product product, HttpServletRequest request) {
		for (CategoryDetails cd : ((List<CategoryDetails>) request.getSession().getAttribute("prodCategoriesList"))) {
			product.addProductCategory(cd);
		}
		prodRepoImpl.updateProduct(product);
		return new RedirectView("/home?getProducts");

	}

	@GetMapping("getDummy")
	public String getDummy() {
//		prodRepoImpl.saveProduct(product);
		return "success";
	}

}
