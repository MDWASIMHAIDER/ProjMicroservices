<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
$(function() {
		$('form[id="userform"]').validate({
			rules : {
				uname : 'required',
				pazzword : 'required',
				email : {
					required : true,
					email : true
				},
				phone : 'required',
				status: 'required'
			},
			messages : {
				uname : 'Please enter username',
				pazzword : 'please enter password',
				email : 'Please enter valid email',
				phone : 'please enter phone number',
				status: 'please enter status'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1 style="color:blue">Register User</h1>
</head>
<body style="background-color:cyan">
<h1>${msg}</h1>
	<form:form action="regForm" method="POST" modelAttribute="ucmd" id="userform">
		<table>
			<tr>
			<td>User Name</td>
			<td><form:input path="uname"/></td>
			</tr>
			
			<tr>
			<td>Password</td>
			<td><form:input path="pazzword"/></td>
			</tr>
			
			<tr>
			<td>Email</td>
			<td><form:input path="email"/></td>
			</tr>
			
			<tr>
			<td>Phone No</td>
			<td><form:input path="phone"/></td>
			</tr>
			
			<tr>
				<td>Country :</td>
				<td><form:select path="countries">
					  <form:option value="NONE" label="--- Select ---" />
					  <form:options items="${countrylist}" />
				       </form:select>
                                </td>
			</tr>
			
			<tr>
			<td>Status</td>
			<td><form:input path="status"/></td>
			</tr>
			
			<tr>
			<td><input type="submit" value="submit"/></td>
			<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
		<h1><a href="showAllRecord?cpage=1" style="text-decoration: none">get All Record</a></h1>
	</form:form>
</body>
</html>