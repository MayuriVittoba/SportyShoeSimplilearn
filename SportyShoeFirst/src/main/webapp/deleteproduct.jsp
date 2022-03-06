<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.Product"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<p>Delete Product</p>
	<form:form id="deleteProduct" action="/deleteProd"
		modelAttribute="product" var="product">


		<p>${product.prodName}</p>
		<p>${product.prodCode}</p>
		<p>${product.prodPrice}</p>
		<p>${product.prodDesc}</p>
		<p>${product.productCategory}</p>

		<input type="hidden" id="prodId" name="prodId"
			value="${product.prodId}" />
		<br>
		<input type="hidden" id="prodName" name="prodName"
			value="${product.prodName}" />
		<br>
		<input type="hidden" id="productCategory" name="productCategory"
			value="${product.productCategory}" />
		<br>
		<input type="hidden" id="productCategories" name="productCategories"
			value="${product.productCategories}" />
		<br>


		<br />
		<br />
		<input type="submit" value="Delete" />
	</form:form>

</body>
</html>