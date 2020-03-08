<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		$('form[id="vform"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				email : {
					required : true,
					email : true
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


</head>
<body>
<h1 style="text-align: center;background-color:orange">Vechile Owner Detail</h1>
	<form:form style="text-align: center" modelAttribute="vodcmd" action="vechileDetail" method="POST" id="vform">
		<table style="border:1">
			<tr>
				<td>First-Name</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last-Name</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:input path="gender"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><form:input path="phone"/></td>
			</tr>
			<tr>
				<td>Dob</td>
				<td><form:input path="dob" id="datepicker"/></td>
			</tr>
		
			<tr>
				<td><input type="submit"  name="_target1"  value="next"/></td>
				<td><input type="submit"  name="_cancel"  value="cancel"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>