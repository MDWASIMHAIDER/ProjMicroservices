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
	<table border="1">
		<thead>
			<tr>
				<td>Agency Name</td>
				<td>Owner Name</td>
				<td>Gender</td>
				<td>City</td>
				<td>Email</td>
				<!-- <td>Password</td> -->
				<td>Phone</td>
				<td>Pin</td>
				<td>Role</td>
				<td>Status</td>
				<td>Active Switch</td>
				<td>Date of Birth</td>
				<!-- <td></td>
				<td></td> -->
			</tr>
		</thead>
		<c:forEach var="agency" items="${getAllAgencyDetails}">
			<tr>
				<td>${agency.agencyName}</td>
				<td>${agency.ownerName}</td>
				<td>${agency.gender}</td>
				<td>${agency.city}</td>
				<td>${agency.email}</td>
				<td>${agency.phone}</td>
				<td>${agency.pin}</td>
				<td>${agency.role}</td>
				<td>${agency.status}</td>
				<td>${agency.active_Switch}</td>
				<td>${agency.dob}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<table border="1">
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Phone</td>
				<td>Date of Birth</td>
				<td>Gender</td>
				<td>Status</td>
				<td>Role</td>
				<td>Active Switch</td>
			</tr>
		</thead>
		
		<c:forEach  var="users" items="${allUserDetails }">
			<tr>
				<td>${users.firstName}</td>
				<td>${users.lastName}</td>
				<td>${users.email}</td>
				<td>${users.phone}</td>
				<td>${users.dob}</td>
				<td>${users.gender}</td>
				<td>${users.status}</td>
				<td>${users.role}</td>
				<td>${users.active_switch}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>