<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function() {
		$('form[id="adminId"]').validate({
			rules : {
				adminId : {
					required : true,
					email : true,
					maxlength : 35
				},
				adminPassword : 'required'
			},
			messages : {
				adminId : 'Please enter email Id',
				cadminPassword: 'please enter password'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
	<div class="" id=""
		style="background: none repeat-x scroll 4px 3px #6E7B58;
		 left: 900px; width: 320px; text-align:left;border:10px;
		  height: 100%; position: fixed; opacity: 100;
		   filter: alpha(opacity = 60); z-index: 1000; 
		   box-shadow: 0 0 15px black; border-radius: 20px;
		    margin-top: 5%; border-color: white;outline: none;
		    padding: 20px;padding-top: 30px;position: inherit;">
		<h1>Admin Login</h1>
		<form:form id="adminId" modelAttribute="adminlogincmd" method="POST" action="loginurl">
			<c:choose>
				<c:when test="${empty unauthorized}">
					
				</c:when>
				<c:otherwise>
					${unauthorized }
				</c:otherwise>
			</c:choose>
			
			<table>
				
				<tr>
					<td>User Id</td>
					<td><form:input path="adminId" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="adminPassword" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none;" /></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" size="15px" style="width: 100px;border-radius: 15px;border: none;padding: 5px;"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>