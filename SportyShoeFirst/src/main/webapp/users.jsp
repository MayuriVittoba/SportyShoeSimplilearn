<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.example.demo.UserLoginDetails"%>
<body>
	<form action="/searchUser" method="post">
		<input type="submit" value="Search User" /> <input type="text"
			name="username" /> <br /> <br />

	</form>
	<table style="width: 50%">
		<tr>
			<th>USER NAME</th>
		</tr>
		<%
		List<UserLoginDetails> list = (ArrayList<UserLoginDetails>) request.getAttribute("listUsers");
		%>

		<c:forEach var="user" items="<%=list%>">
			<table style="width: 50%">
				<tr>
					<td>${user.userName}</td>
				</tr>
			</table>
		</c:forEach>
	</table>
	<a href="/home?getProducts"> <input type="submit" value="Back" />
	</a>
</body>