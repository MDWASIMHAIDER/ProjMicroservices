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
	<%-- <form:form action="report" modelAttribute="reportcmd" method="Post"> --%>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Phone</td>
				<td>Address</td>
				<td>Pin</td>
				<td>Operation</td>
			</tr>
			
				<c:forEach var="st" items="${studentlist}">
				<tr>
					<td>${st.id}</td>
					<td>${st.name}</td>
					<td>${st.phone}</td>
					<td>${st.address}</td>
					<td>${st.pin}</td>
					<td><a href="delete?id=${st.id}">Delete</a></td>
					<td><a href="update?id=${st.id}">Update</a></td>
					
					</tr>
				</c:forEach>
			
		</table>
	<%-- </form:form> --%>
</body>
</html>