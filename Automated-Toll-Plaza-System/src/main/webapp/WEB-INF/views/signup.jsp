<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		$('form[id="signUpValidation"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				email : {
					required : true,
					email : true,
					maxlength : 35
				},
				gender : 'required',
				phone: 'required',
				dob: 'required'
			},
			messages : {
				firstName : 'Please enter FirstName',
				lastName : 'please enter LastName',
				email : 'Please enter valid email',
				phone : 'please enter phone number',
				gender: 'please enter gender',
				dob: 'please enter date of birth'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
  </script>
<style type="text/css">
table <tr{
	padding-bottom: 10px;
}

input {
	size: 14px;
}
</style>
</head>
<body style="background-color: green;";>
	<div class="" id=""
		style="background: none repeat-x scroll 4px 3px lightgoldenrodyellow; left: 450px; width: 370px; text-align: center; height: 400px; position: fixed; opacity: 0.50; filter: alpha(opacity = 60); z-index: 1000; box-shadow: 0 0 15px black; border-radius: 20px; margin-top: 4%; border-color: white;">
		<form:form id="signUpValidation" action="signupurl" modelAttribute="signupcmd" method="POST">
			
			<c:choose>
				<c:when test="${empty temporaryPassowrd}">
					
				</c:when>
				<c:otherwise>
					Registration Done
    				Temporary Password Has sent to mail !!!
				</c:otherwise>
			</c:choose>
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" size="35px" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" size="35px"/></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><form:input path="email" size="35px"/></td>
				</tr>
				<tr>
					<td>Phone No</td>
					<td><form:input path="phone" size="35px"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:radiobuttons items="${genderlist}" path="gender" size="35px"/></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><form:input path="dob" size="32px" id="datepicker"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="sign up"></td>

				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>