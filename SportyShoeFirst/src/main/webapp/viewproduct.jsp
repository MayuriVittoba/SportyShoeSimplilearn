<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.Product"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>
<p>View Product</p>
	<form:form modelAttribute="product" var="product">
		
		
		<p>${product.prodName}</p>
		<p>${product.prodCode}</p>
		<p>${product.prodPrice}</p>
		<p>${product.prodDesc}</p>
		
	
		
    
    <br/><br/>
   
   
</form:form>
	
	<a href="/home?getProducts"> <input type="submit" value="Back" />
	</a>	
</body>
</html>