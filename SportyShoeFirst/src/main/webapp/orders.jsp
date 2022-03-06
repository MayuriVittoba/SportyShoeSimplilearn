<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.example.demo.Orders"%>
<body>
	<form action="/sortProducts" method="post">
		<input type="submit" value="Sort Products" /> 
		
		<input type="text" name="dateOfOrder" /> <br /> <br /> 
			<select name="category">
			<option value="-1">ALL</option>
			<c:forEach items="${listCategory}" var="category">
			<option value="${category.categoryId}">${category.categoryName}</option>
			</c:forEach>
		</select> <br /> <br />

	</form>
	<table style="width: 50%">
		<tr>
			<th>USER NAME</th>
		</tr>
		<%
		List<Orders> list = (ArrayList<Orders>) request.getAttribute("listOrders");
		%>

		<c:forEach var="order" items="<%=list%>">
			<table style="width: 50%">
				<tr>
					<td>${order.orderCode}</td>
					<td>${order.userName}</td>
					<td>${order.prodName}</td>
				</tr>
			</table>
		</c:forEach>
	</table>
	<a href="/home?getProducts"> <input type="submit" value="Back" />
	</a>
</body>