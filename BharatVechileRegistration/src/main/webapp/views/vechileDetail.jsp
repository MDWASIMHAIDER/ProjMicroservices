<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1 style="text-align: center;background-color: orange">Vechile Details</h1>
</head>
<body style="text-align: center">
	<form:form modelAttribute="vdcmd" method="POST" action="vechiledtl">
		<table style="border:1">
			<tr>
				<td>Vechile-Type</td>
				<td><form:input path="vechileType"/></td>
			</tr>
			<tr>
				<td>Manufacturing Year</td>
				<td><form:input path="mfgYear"/></td>
			</tr>
			<tr>
				<td>Vechile-Brand</td>
				<td><form:input path="vechileBrand"/></td>
			</tr>
			<tr>
				<td><input type="submit"  name="_target0"  value="previous"></td>
				<td><input type="submit"  name="_target2"  value="next"></td>
           	    <td><input type="submit"  name="_cancel"  value="cancel"></td>
           	 </tr>
		
		</table>
	</form:form>
</body>
</html>