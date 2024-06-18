<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>FirstName</td>
			<td>Email</td>
			<td>Action</td>
		</tr>

		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.firstName }</td>
				<td>${u.email}</td>
				<td>
				<a href="deleteuser?userId=${u.userId}">Delete</a>
					| 
				<a href="viewuser?userId=${u.userId}">View</a>
					
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>