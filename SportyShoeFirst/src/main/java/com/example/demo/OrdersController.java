package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersController {

	@Autowired
	OrderRepositoryImpl orderRepoImpl;
	@Autowired
	CategoryRepository categoryRepo;

	@RequestMapping("/sortProducts")
	public ModelAndView sortProducts(HttpServletRequest request) {
		ModelAndView obj = new ModelAndView("orders.jsp");
		String dateOfOrder = request.getParameter("dateOfOrder");
		int catId = Integer.parseInt(request.getParameter("category"));

		List<Orders> orderList = new ArrayList<>();
		if (dateOfOrder.isBlank() && catId == -1) {
			orderList = orderRepoImpl.getAllOrders();
		} else if (!dateOfOrder.isBlank() && catId != -1) {
			orderList = orderRepoImpl.getOrdersByDateAndCategory(catId, dateOfOrder);
		} else if (catId != -1) {
			orderList = orderRepoImpl.getOrdersByCategory(catId);
		} else if (!dateOfOrder.isBlank()) {
			orderList = orderRepoImpl.getOrdersByDate(dateOfOrder);
		}
		obj.addObject("listOrders", orderList);
		List<CategoryDetails> listCategory = categoryRepo.findAll();

		obj.addObject("listCategory", listCategory);
		return obj;
	}

}
