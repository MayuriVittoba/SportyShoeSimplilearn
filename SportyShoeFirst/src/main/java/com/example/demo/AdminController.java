package com.example.demo;

import java.util.List;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	AdminRepositoryImpl adminRepositoryImpl;

	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin(HttpServletRequest request, HttpServletResponse response) {
		String adminEmail = request.getParameter("adminEmail");
		String adminPwd = request.getParameter("adminPwd");

		AdminDetails adminDetails;

		ModelAndView mv = new ModelAndView();
		if (adminEmail.isBlank() || adminEmail == null || adminPwd.isBlank() || adminPwd == null) {
			mv.setViewName("adminlogin.jsp");
			mv.addObject("loginError", "Enter valid credentials");
		} else {
			adminDetails = adminRepositoryImpl.findAdminByEmail(adminEmail);
			if (adminDetails != null) {
				if (adminDetails.getAdminPwd().equals(adminPwd)) {
					mv.setViewName("/home?getProducts");
					mv.addObject("adminName", adminDetails.getAdminName());
				} else {
					mv.setViewName("adminlogin.jsp");
					mv.addObject("loginError", "Incorrect Password");
				}
			} else {
				mv.setViewName("adminlogin.jsp");
				mv.addObject("loginError", "No Admin Email found");
			}
		}
		return mv;

	}

	@RequestMapping("/changepassword")
	public ModelAndView adminPasswordChange(HttpServletRequest request, HttpServletResponse response) {
		String adminEmail = request.getParameter("adminEmail");
		String adminPwd = request.getParameter("adminPwd");
		String adminRePwd = request.getParameter("adminRePwd");
		ModelAndView mv = new ModelAndView("adminChangePwd.jsp");
		if (adminEmail.isBlank() || adminEmail == null) {

			mv.addObject("msg", "Please enter valid email");
		} else {
			AdminDetails adminDetails = adminRepositoryImpl.findAdminByEmail(adminEmail);

			if (adminDetails != null) {
				if (adminPwd.equals(adminRePwd)) {
					adminDetails.setAdminPwd(adminPwd);
					adminRepositoryImpl.changeAdminPwd(adminDetails);
					mv = new ModelAndView("adminlogin.jsp");
					mv.addObject("loginError", "Password changed successfully");
				} else {
					mv.addObject("msg", "password mismatch");
				}

			} else {

				mv.addObject("msg", "No Admin Email found");
			}
		}
		return mv;

	}

	@Autowired
	ProductRepositoryImpl prodRepoImpl;
	@Autowired
	CategoryRepository categoryRepo;

	@RequestMapping(value = "/home", params = "getProducts")
	public ModelAndView getProducts(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("home.jsp");
		List<Product> listProduct = prodRepoImpl.getAllProducts();
		mav.addObject("listProduct", listProduct);

		List<CategoryDetails> listCategory = categoryRepo.findAll();
		mav.addObject("listCategory", listCategory);
		return mav;

	}
}
