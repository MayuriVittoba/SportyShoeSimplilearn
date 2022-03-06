package com.example.demo;

import java.util.List;

public interface OrderRepository {
	public List<Orders> getOrdersByDateAndCategory(int categoryId, String orderDate);

	public List<Orders> getAllOrders();

	public List<Orders> getOrdersByDate(String orderDate);

	public List<Orders> getOrdersByCategory(int categoryId);
}
