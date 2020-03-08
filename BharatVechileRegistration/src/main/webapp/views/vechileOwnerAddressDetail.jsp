<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1 style="text-align: center;background-color: orange">Vechile Owner Address Detail</h1>

<body style="text-align:center">
	<form:form  modelAttribute="voadcmd" method="POST" action="ownerdetail">
		<table style="border:1">
			<tr>
				<td>Home No</td>
				<td><form:input path="homeno"/></td>
			</tr>
			<tr>
				<td>Street-Name</td>
				<td><form:input path="streetName"/></td>
			</tr>
			<tr>
				<td>city</td>
				<td><form:input path="city"/></td>
			</tr>
			<tr>
				<td>Zip-Code</td>
				<td><form:input path="zipCode"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="_target1" value="previous"/></td>
				<td><input type="submit"  value="Next"/></td>
				<td><input type="reset" name="_cancel" value="Reset"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>