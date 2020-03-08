<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="./resource/core/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="./resource/core/js/app.js"></script>
  
  <spring:url value="/resource/core/js/app.js"
	var="jqueryJs" />
	<script src="${jqueryJs}"></script>
</head>
<body style="background-image: linear-gradient(to right, yellow, red);">
	<h1>Manage Accounts</h1>
	<a href="/adminController/agencyForm">Create new Agent Account</a>&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/signupcontroller/signup">Create new User Account</a>&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/adminController/allAgencyDetail">View Agencies</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/adminController/allUserDetail">View Users</a>


	<c:choose>

		<c:when test="${empty getAllAgencyDetails and empty allUserDetails}">

		</c:when>

		<c:when test="${not empty getAllAgencyDetails}">

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
						<td>Action</td>
						<!--<td></td> -->
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

						<c:choose>
							<c:when test="${agency.active_Switch == 'Y'}">
								<td><a
									href="/adminController/deactivateagency?emailId=${agency.email}">Deactivate</a></td>
							</c:when>
							<c:otherwise>
								<td><a
									href="/adminController/activateagency?emailId=${agency.email}">Activate</a></td>
							</c:otherwise>

						</c:choose>

					</tr>
				</c:forEach>
			</table>
			<select id="role" name="role">
				<option value="NONE">--- Select ---</option>
				<option value="Locked">Inactive</option>
				<option value="Unlockrd">Active</option>

			</select>
		</c:when>
		<c:otherwise>


			<br>
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
						<td>Action</td>
					</tr>
				</thead>

				<c:forEach var="users" items="${allUserDetails }">
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
						<c:choose>
							<c:when test="${users.active_switch == 'Y'}">
								<td><a
									href="/signupcontroller/deactivateuser?emailId=${users.email }">Deactivate</a></td>
							</c:when>
							<c:otherwise>
								<td><a
									href="/signupcontroller/activateuser?emailId=${users.email }">Activate</a></td>
							</c:otherwise>

						</c:choose>

					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>