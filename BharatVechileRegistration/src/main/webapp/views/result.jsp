<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1>Thanks For Registration </h1>
</head>
<body>
	<h1><a href="user">Home</a></h1>
	<form:form modelAttribute="rgcmd" method="POST" action="regdtl">
		<table style="border:1">
			<tr>
				<td>Registration Center</td>
				<td><form:input path="reg_center"/></td>
			</tr>
			<tr>
				<td><input type="submit"  value="Submit"></td>
				
           	 </tr>
		</table>
	</form:form>
</body>
</html>