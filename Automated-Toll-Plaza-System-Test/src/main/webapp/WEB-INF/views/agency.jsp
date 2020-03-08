<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
  <script type="text/javascript" src="./resource/core/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="./resource/core/js/app.js"></script> 
<script>
$(function() {
		$('form[id="agencyId"]').validate({
			rules : {
				role : 'required',
				agencyName : 'required',
				
				ownerName : 'required',
				city : 'required',
				email : {
					required : true,
					email : true,
					maxlength : 35
				},
				phone: 'required',
				pin : 'required',
				dob: 'required'
			},
			messages : {
				role : 'Please select role',
				agencyName: 'please enter agency name',
				ownerName: 'please enter name',
				city: 'please enter city',
				email: 'please enter email',
				phone: 'please enter phone no',
				pin: 'please eneter pin',
				dob: 'please enter birth date'
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
  <spring:url value="/resource/core/js/app.js"
	var="jqueryJs" />
	<script src="${jqueryJs}"></script>
</head>
</head>
<body style=" background-image: linear-gradient(to right, red , yellow);">

	<div class="" id=""
		style="background: none repeat-x scroll 4px 3px #6E7B58;
		 left: 450px; width: 340px; text-align:left;
		  height:540px; opacity: 100;
		   filter: alpha(opacity = 60); z-index: 1000; 
		   box-shadow: 0 0 15px black; border-radius: 20px;
		    margin-top: 5%; border-color: white;outline: none;
		    padding: 25px; background-image: linear-gradient(to right, #92ed5c , #acb0a9);">
	<h1>Create New Account</h1>
	<form:form id="agencyId" modelAttribute="agencycmd" action="agencyurl" method="POST">
		<table>
			<tr>
				<td>Role</td>
				<td><form:select items="${accountroles}" path="role" cssStyle="width:240px;border-radius:15px;height:30px;outline:none;font-size:16px;"/></td>
			</tr>
			<tr>
				<td>Agency Name</td>
				<td><form:input path="agencyName" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
			</tr>
			<tr>
				<td>Owner Name</td>
				<td><form:input path="ownerName" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input path="city" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
			</tr>
			<tr>
				<td>Email Id</td>
					<td><form:input path="email" id="email1" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none;"/></td>
					<div id="emailErrorMsg1" style="color:white"></div>
					
				</tr>
			<tr>
				<td>Phone</td>
				<td><form:input path="phone" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
			</tr>
			<tr>
				<td>Pin Code</td>
				<td><form:input path="pin" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:radiobuttons items="${genderlist}" path="gender" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><form:input path="dob" id="datepicker" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
			</tr>
			
			<tr >
				<td colspan="2" align="center"><input type="submit" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>