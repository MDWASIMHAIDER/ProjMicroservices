<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function confirmDelete(){
		return confirm("Are you sure");
	}
</script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>Serial No</td>
				<td>User Name</td>
				<td>Phone No</td>
				<td>Password</td>
				<td>Email Id</td>
				<td>Country</td>
				<td>Status</td>
				<td>Action</td>
			</tr>
		</thead>
		
		
			<c:forEach var="user" items="${userList}">
				<tr><td>${user.serialNumber}</td>
				<td>${user.uname}</td>
				<td>${user.phone }</td>
				<td>${user.pazzword }</td>
				<td>${user.email }</td>
				<td>${user.countries}</td>
				<td>${user.status }</td>
				<td><b><a href="editUser?uid=${user.serialNumber}" style="text-decoration: none">Edit</a></b>
					<b><a href="deleteUser?uid=${user.serialNumber}" onclick="return confirmDelete()" style="text-decoration: none">Delete</a></b>
				</td>
				</tr>
			</c:forEach>
	
	</table>
	
	<c:if test="${currentpage>1 }">
		<a href="showAllRecord?cpage=${currentpage-1 }">Previous</a>
	</c:if>
	<c:forEach begin="1" end="${pagesize}" var="i">
		
		<c:choose>
			<c:when test="${currentpage==i}">
				<c:out value="${ i}"/>
			</c:when>
			<c:otherwise>
				<a href="showAllRecord?cpage=${i}"><c:out value="${i}"/></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${currentpage<pagesize}">
		<a href="showAllRecord?cpage=${currentpage+1 }">Next</a>
	</c:if>
	<h1><a href="regForm" style="text-decoration: none">Home</a> &nbsp;&nbsp;&nbsp;<a href="regForm" style="text-decoration: none">Insert New Record</a></h1>
</body>
</html>