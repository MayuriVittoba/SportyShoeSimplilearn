package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepositoryImpl prodRepo;

//    @RequestMapping("/showForm")
//    public String showForm()
//    {
//        return "welcome";
//    }
	@RequestMapping(value = "/newProduct")
	public ModelAndView newProduct(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView obj = new ModelAndView("newproduct.jsp");
		obj.addObject("product", new Product());
		return obj;
	}

	@RequestMapping(value = "/productByCategory") // method = RequestMethod.POST)
	public ModelAndView productByCategory(HttpServletRequest request) {

		int catId = Integer.parseInt(request.getParameter("category"));
		List<Product> productList;
		ModelAndView mav = new ModelAndView("home.jsp");
		if (catId != -1) {
			productList = prodRepo.getProductByCategory(catId);
		} else {
			productList = prodRepo.getAllProducts();
		}
		mav.addObject("listProduct", productList);
		List<CategoryDetails> listCategory = categoryRepository.findAll();
		mav.addObject("listCategory", listCategory);

		return mav;

	}

	// @ResponseBody
	@RequestMapping(value = "/editProduct/{id}")
	public ModelAndView editProduct(@PathVariable("id") int id, HttpServletRequest request) {
		Product product = prodRepo.getProductById(id);
		request.getSession().setAttribute("prodCategoriesList", product.getProductCategories());
		ModelAndView obj = new ModelAndView("/editproduct.jsp");
		obj.addObject("product", product);
		return obj;
	}

	@RequestMapping(value = "/deleteProduct/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int id) {
		Product product = prodRepo.getProductById(id);
		ModelAndView obj = new ModelAndView("/deleteproduct.jsp");
		obj.addObject("product", product);
		return obj;
	}

	@RequestMapping(value = "/viewProduct/{id}")
	public ModelAndView viewProduct(@PathVariable("id") int id) {
		Product product = prodRepo.getProductById(id);
		ModelAndView obj = new ModelAndView("/viewproduct.jsp");
		obj.addObject("product", product);
		return obj;
	}

	@Autowired
	UserRepositoryImpl userRepoImpl;

	@RequestMapping(value = "/goToUsers") // , method = RequestMethod.POST)//, params = "newProduct")//, method =
	// RequestMethod.POST)
	public ModelAndView goToUsers() {
		ModelAndView obj = new ModelAndView("users.jsp");
		obj.addObject("listUsers", userRepoImpl.getLoggedInUsers());
		return obj;

	}

	@Autowired
	OrderRepositoryImpl orderRepoImpl;
	@Autowired
	CategoryRepository categoryRepo;

	@RequestMapping(value = "/goToOrders") // , method = RequestMethod.POST)//, params = "newProduct")//, method =
	// RequestMethod.POST)
	public ModelAndView goToOrders() {
		System.out.println("newProduct calleddd---");
		ModelAndView obj = new ModelAndView("orders.jsp");
		obj.addObject("listOrders", orderRepoImpl.getAllOrders());
		List<CategoryDetails> listCategory = categoryRepo.findAll();

		obj.addObject("listCategory", listCategory);
		return obj;
	}
}
