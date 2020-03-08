<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="regurl" method="POST">
		Registration Number:-<input type="text" name="regNo" placeholder="Enter vechile RegNo"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Search">
	
	</form>
	<!-- ${vechileDetails} for getting all data comming as response -->
	<%-- ${vechileDetails.owner.email} --%>
	
	
	<c:choose>
		<c:when test="${not empty vechileDetails}">
			<form action="tagurl" method="POST" modelAttribute="tagcmd">
				<table>
					<tr>
						<td>Vechile Reg No</td>
						<td><input type="text" value="${vechileDetails.registration.vechile_Reg_Num }" name="vechileRegNumber"/></td>
					</tr>
					<tr>
						<td>Vechile Type</td>
						<td><input type="text" value="${vechileDetails.vechile.vechileType}" name="vechileType"/></td>
					</tr>
					<tr>
						<td>User Id</td>
						<td><input type="text" value="${signUpId}" name="userId"/></td>
					</tr>
					<tr>
						<td>Created By</td>
						<td><input type="text" value="${fullName}" name="createdBy"/></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><input type="submit" value="proceed"></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			${statusCodeValue}
		</c:otherwise>
	</c:choose>

</body>
</html>