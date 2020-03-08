<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form:form action="processform" modelAttribute="studentcmd" method="Post">
		<h1 style="color:blue;text-align: center">Student Registration</h1>
		${reesult}
		<table style="align-content:center">
			<tr>
				<td>Student Name</td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address"></form:input></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><form:input path="phone"></form:input></td>
			</tr>
			<tr>
				<td>Father</td>
				<td><form:input path="father"></form:input></td>
			</tr>
			<tr>
				<td>Pin Code</td>
				<td><form:input path="pin"></form:input></td>
			</tr>
			<tr>
				<td rowspan="2" style="text-align: center;"><input type="submit" value="Register"></td>
			</tr>
		</table>
		<h1><a href="report"> Get All Student</a></h1>
	</form:form>
	</div>
</body>
</html>