<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<center>
		<a href="<%=application.getContextPath()%>/register-employee.jsp">Add
			User</a>
	</center>
	<table style="border: 1;" border="1" align="center">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile</th>
			<th>User Name</th>
			<th>Password</th>
			<th>Action</th>

		</tr>

		<c:forEach var="employee" items="${employees}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${employee.getFirstName}</td>
				<td>${employee.getLastName}</td>
				<td>${employee.getMobileNumber}</td>
				<td>${employee.getUserName}</td>
				<td>${employee.getPassword}</td>
				<td><span><a
						href="<%=application.getContextPath()%>/delete-employee?employeeId=${employee.employeeId}">Delete</a></span>
					<span><a
						href="<%=application.getContextPath()%>/update-employee?employeeId=${employee.employeeId}>">Edit</a></span>
				</td>
			</tr>
		</c:forEach>



	</table>


</body>
</html>