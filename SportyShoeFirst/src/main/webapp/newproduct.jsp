<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.Product"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New</title>
</head>
<body>
<p>New Product</p>
		
		 <form:form id="insertProduct" method="post" action="insertProduct" modelAttribute="product">
 
 <form:label path="prodId">Product ID</form:label>
            <form:input id="prodId" name="prodId" path="prodId"/><br>
 
            <form:label path="prodName">Product name</form:label>
            <form:input id="prodName" name="prodName" path="prodName"/><br>
            
            <form:label path="prodCode">Product code</form:label>
            <form:input id="prodCode" name="prodCode" path="prodCode" /><br>
            
            <form:label path="prodPrice">Product price</form:label>
            <form:input id="prodPrice" name="prodPrice" path="prodPrice" /><br>
            
             <form:label path="prodDesc">Product desc</form:label>
            <form:input id="prodDesc" name="prodDesc" path="prodDesc" /><br>
            
             
            
             <form:label path="productCategory">Product category</form:label>
            <form:input id="productCategory" name="productCategory" path="productCategory" /><br>
            
            <input type="submit" value="Save" />
        </form:form>
		
		
		
</body>
</html>