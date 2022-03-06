package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public List<Orders> getOrdersByDateAndCategory(int categoryId, String orderDate) {
		Query query = entityManager.createNativeQuery(
				"select o.order_id,u.user_id,o.order_date,o.order_code,u.user_name,p.prod_id,p.prod_name "
						+ "from orders o " + "inner join order_details od on o.ORDER_ID=od.ORDER_ID "
						+ "inner join product p on p.prod_id=od.prod_id "
						+ "inner join productandcategory pc on p.prod_id=pc.product_id "
						+ "inner join category c on pc.category_id=c.category_id "
						+ "inner join user_login_Details u on u.user_id=o.user_id where c.category_id=" + categoryId
						+ " and o.order_date='" + orderDate + "'");

		List<Object[]> resultList = (List<Object[]>) query.getResultList();

		List<Orders> savedList = new ArrayList<>();
		for (int i = 0; i < resultList.size(); i++) {
			Object[] obj = resultList.get(i);
			Orders ordersObj = new Orders();
			ordersObj.setOrderId((int) obj[0]);
			ordersObj.setUserId((int) obj[1]);
			ordersObj.setOrderDate((String) obj[2]);
			ordersObj.setOrderCode((String) obj[3]);
			ordersObj.setUserName((String) obj[4]);
			ordersObj.setProdId((int) obj[5]);
			ordersObj.setProdName((String) obj[6]);
			savedList.add(ordersObj);
		}

		return savedList;

	}

	public List<Orders> getAllOrders() {
		Query query = entityManager.createNativeQuery(
				"select o.order_id,u.user_id,o.order_date,o.order_code,u.user_name,p.prod_id,p.prod_name "// ,u.user_name,c.category_name,p.prod_name
																											// "
						+ "from orders o " + "inner join order_details od on o.ORDER_ID=od.ORDER_ID "
						+ "inner join product p on p.prod_id=od.prod_id "
						+ "inner join productandcategory pc on p.prod_id=pc.product_id "
						+ "inner join category c on pc.category_id=c.category_id "
						+ "inner join user_login_Details u on u.user_id=o.user_id");// return type is
		List<Object[]> resultList = (List<Object[]>) query.getResultList();

		List<Orders> savedList = new ArrayList<>();

		for (int i = 0; i < resultList.size(); i++) {
			Object[] obj = resultList.get(i);
			Orders ordersObj = new Orders();
			ordersObj.setOrderId((int) obj[0]);
			ordersObj.setUserId((int) obj[1]);
			ordersObj.setOrderDate((String) obj[2]);
			ordersObj.setOrderCode((String) obj[3]);
			ordersObj.setUserName((String) obj[4]);
			ordersObj.setProdId((int) obj[5]);
			ordersObj.setProdName((String) obj[6]);
			savedList.add(ordersObj);
		}

		return savedList;

	}

	public List<Orders> getOrdersByDate(String orderDate) {
		Query query = entityManager.createNativeQuery(
				"select o.order_id,u.user_id,o.order_date,o.order_code,u.user_name,p.prod_id,p.prod_name "
						+ "from orders o " + "inner join order_details od on o.ORDER_ID=od.ORDER_ID "
						+ "inner join product p on p.prod_id=od.prod_id "
						+ "inner join productandcategory pc on p.prod_id=pc.product_id "
						+ "inner join category c on pc.category_id=c.category_id "
						+ "inner join user_login_Details u on u.user_id=o.user_id where o.order_date='" + orderDate
						+ "'");

		List<Object[]> resultList = (List<Object[]>) query.getResultList();

		List<Orders> savedList = new ArrayList<>();

		for (int i = 0; i < resultList.size(); i++) {
			Object[] obj = resultList.get(i);
			Orders ordersObj = new Orders();
			ordersObj.setOrderId((int) obj[0]);
			ordersObj.setUserId((int) obj[1]);
			ordersObj.setOrderDate((String) obj[2]);
			ordersObj.setOrderCode((String) obj[3]);
			ordersObj.setUserName((String) obj[4]);
			ordersObj.setProdId((int) obj[5]);
			ordersObj.setProdName((String) obj[6]);
			savedList.add(ordersObj);
		}

		return savedList;

	}

	public List<Orders> getOrdersByCategory(int categoryId) {
		Query query = entityManager.createNativeQuery(
				"select o.order_id,u.user_id,o.order_date,o.order_code,u.user_name,p.prod_id,p.prod_name "
						+ "from orders o " + "inner join order_details od on o.ORDER_ID=od.ORDER_ID "
						+ "inner join product p on p.prod_id=od.prod_id "
						+ "inner join productandcategory pc on p.prod_id=pc.product_id "
						+ "inner join category c on pc.category_id=c.category_id "
						+ "inner join user_login_Details u on u.user_id=o.user_id where c.category_id=" + categoryId);

		List<Object[]> resultList = (List<Object[]>) query.getResultList();

		List<Orders> savedList = new ArrayList<>();

		for (int i = 0; i < resultList.size(); i++) {
			Object[] obj = resultList.get(i);

			Orders ordersObj = new Orders();
			ordersObj.setOrderId((int) obj[0]);
			ordersObj.setUserId((int) obj[1]);
			ordersObj.setOrderDate((String) obj[2]);
			ordersObj.setOrderCode((String) obj[3]);
			ordersObj.setUserName((String) obj[4]);
			ordersObj.setProdId((int) obj[5]);
			ordersObj.setProdName((String) obj[6]);
			savedList.add(ordersObj);
		}

		

		return savedList;

	}

}
