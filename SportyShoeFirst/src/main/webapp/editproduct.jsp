<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.Product"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.example.demo.CategoryDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<p>Edit Product</p>
	<form:form id="editProduct" action="/updateProduct" modelAttribute="product" var="product">
		
		
		<form:label path="prodId">Product ID</form:label>
            <form:input id="prodId" name="prodId" path="prodId"/><br>
 
            <form:label path="prodName">Product name</form:label>
            <form:input id="prodName" name="prodName" path="prodName" value="${product.prodName}"/><br>
            
            <form:label path="prodCode">Product code</form:label>
            <form:input id="prodCode" name="prodCode" path="prodCode" value="${product.prodCode}"/><br>
            
            <form:label path="prodPrice">Product price</form:label>
            <form:input id="prodPrice" name="prodPrice" path="prodPrice" value="${product.prodPrice}"/><br>
            
             <form:label path="prodDesc">Product desc</form:label>
            <form:input id="prodDesc" name="prodDesc" path="prodDesc" value="${product.prodDesc}"/><br>
            
             
            
             <form:label path="productCategory">Product category</form:label>
            <form:input id="productCategory" name="productCategory" path="productCategory" value="${product.productCategory}" /><br>
		
		
		<input type="hidden" id="productCategories" name="productCategories"
			value="${product.productCategories}" />
		<br>
		<input type="hidden" id="prodReview" name="prodReview"
			value="${product.prodReview}" />
		<br>
    
    <br/><br/>
    <input type="submit" value="Save" />
</form:form>
		
</body>
</html>