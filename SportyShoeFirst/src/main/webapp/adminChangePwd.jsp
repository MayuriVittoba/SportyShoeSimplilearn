<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<form:form id="loginForm" method="post" action="/changepassword"
		modelAttribute="adminBean">
		<label path="adminEmail">Enter your Email</label>
		<input id="adminEmail" name="adminEmail" path="adminEmail" />
		<br>
		<label path="adminPwd">Please enter your password</label>
		<input id="adminPwd" name="adminPwd" path="adminPwd" />
		<br>
		<label path="adminRePwd">Please re enter your password</label>
		<input id="adminRePwd" name="adminRePwd" path="adminRePwd" />
		<br>
		<input type="submit" value="Change password" />
	</form:form>
	<div style="color: red">${msg}</div>
</body>
</html>