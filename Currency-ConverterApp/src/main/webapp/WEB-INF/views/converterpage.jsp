<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Currency Convereter</h1>
	<form:form action="cost" method="POST" modelAttribute="ccmd">
		<table border="1">
			<tr>
				<td>From</td>
				<td><form:input path="from"/></td>
			</tr>
			<tr>
				<td>To</td>
				<td><form:input path="to"/></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><form:input path="amountQuantity"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
				<td>${totalCost}</td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>