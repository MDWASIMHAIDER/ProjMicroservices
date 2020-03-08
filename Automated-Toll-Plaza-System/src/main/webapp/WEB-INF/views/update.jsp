<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Unlock Account</h1>
	
	<form:form id="#" action="updateurl" method="POST" modelAttribute="updatecmd">
			
			
			<table>
				<tr>
					<td>Email</td>
					<td>${email}</td>
				<tr>
					<td>Temporary Password</td>
					<td><form:input path="tempPassword" /></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><form:input path="newPassword" /></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><form:input path="confirmPassword" /></td>
				</tr>
				
				<tr style="column-span: 2">
					<td><input type="submit" value="update"></td>
				</tr>
			</table>
		</form:form>
</body>
</html>