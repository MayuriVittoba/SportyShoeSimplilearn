<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.example.demo.Product"%>
<%@ page import="com.example.demo.ProductRepositoryImpl"%>
<!DOCTYPE html>
<html>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<body>

	<h2>Products</h2>
	<a href="/newProduct"> <input type="submit" value="New Product" />
	</a>
	<a href="/goToUsers"> <input type="submit" value="Go to Users" />
	</a>
	<a href="/goToOrders"> <input type="submit" value="Go to Orders" />
	</a>


	<form action="/productByCategory" method="post">
		<input type="submit" value="By Category" /> <select name="category">
			<option value="-1">ALL</option>
			<c:forEach items="${listCategory}" var="category">

				<option value="${category.categoryId}">${category.categoryName}</option>
			</c:forEach>
		</select> <br />
		<br />

	</form>



	<table style="width: 100%">
		<tr>
			<th>NAME</th>
			<th>PRICE</th>
			<th>REVIEW</th>
			<th>Manipulate</th>

		</tr>

		<%
		List<Product> list = (ArrayList<Product>) request.getAttribute("listProduct");
		%>

		<c:forEach var="product" items="<%=list%>">
			<table style="width: 100%">
				<tr>
					<td>${product.prodName}</td>
					<td>${product.prodPrice}</td>
					<td>${product.prodReview}</td>
					<td>${product.productCategory}</td>
					<td><a href="/editProduct/${product.prodId}">Edit</a> <a
						href="/deleteProduct/${product.prodId}">Delete</a> <a
						href="/viewProduct/${product.prodId}">View</a></td>
					<%-- <input type="hidden" name="roomno" value="${product.prodId}" /> 
					<input type="hidden" name="roomno" value="${product}"/>--%>
					
				</tr>
			</table>
		</c:forEach>
	</table>
</body>
</html>