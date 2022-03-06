<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>

<title>Login</title>
</head>
<body>
	<form id="loginForm" method="post" action="/adminlogin">

		Enter email <input id="adminEmail" name="adminEmail" /> <br>
		Please enter password <input type="password" id="adminPwd"
			name="adminPwd" path="adminPwd" /> <br> <input type="submit"
			value="Login" />

	</form>
	<form action="/adminChangePwd.jsp">
		<input type="submit" value="Change Password" />
	</form>
<div style="color: red">${loginError}</div>
</body>
</html>