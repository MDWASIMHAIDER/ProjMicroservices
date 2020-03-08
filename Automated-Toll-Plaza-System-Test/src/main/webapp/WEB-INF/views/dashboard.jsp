<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	a{
		text-decoration: none;
	}
	h1{
		margin-left: 1200px;
	}
</style>
</head>
<body>
	 <c:if test="${not empty signUpId}">
	<br><a href="/tagcontroller/mytag">My Tag</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#">Recharge Tag</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/tagcontroller/purchasetagurl">Purchase New Tag</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#">View Tag Transaction</a>
	<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
	<a href="/logincontroller/showlogin" style="margin-left: 1000px;">LogOut</a><span style="color: cyan"> ${fullName}</span>
	<br>${availabltag}
	</c:if>
	<c:choose>
		<c:when test="${not empty mytagclicked}">
			<br><h1>Plz Wait</h1>
		</c:when>
	</c:choose>
</body>
</html>