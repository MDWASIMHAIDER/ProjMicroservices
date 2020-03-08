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
		$('form[id="updateValidation"]').validate({
			rules : {
				email : {
					required : true,
					email : true,
					maxlength : 35
				},
				tempPassword : 'required',
				newPassword: 'required',
				confirmPassword: 'required'
			},
			messages : {
				email : 'Please enter valid email',
				tempPassword : 'please enter password',
				newPassword: 'please enter password',
				confirmPassword: 'please enter password'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>

<body>
	<h1>Unlock Account</h1>
	<div class="" id=""
		style="background: none repeat-x scroll 4px 3px #6E7B58;
		 left: -900px; width: 380px; text-align:left;border:10px;
		  height: 100%; position: fixed; opacity: 100;
		   filter: alpha(opacity = 60); z-index: 1000; 
		   box-shadow: 0 0 15px black; border-radius: 20px;
		    margin-top: 5%; border-color: white;outline: none;
		    padding: 20px;padding-top: 30px;float:left;position: inherit;">
	<form:form id="updateValidation" action="updateurl" method="POST" modelAttribute="updatecmd">
			
			<c:choose>
				<c:when test="${empty Unlocked}">
					
				</c:when>
				<c:otherwise>
					${Unlocked}
				</c:otherwise>
			</c:choose>
			<table>
				<tr>
					<td>Email</td>
					<td><form:input path="email" size="32px" value="${email}" readonly="readonly" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none;"/></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><form:input path="role" size="32px" value="${role}" readonly="readonly" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none;"/></td>
				</tr>
				<tr>
					<td>Temporary Password</td>
					<td><form:input path="tempPassword" size="32px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none;"/></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><form:input path="newPassword" size="32px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none;"/></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><form:input path="confirmPassword" size="32px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none;"/></td>
				</tr>
				
				<tr style="column-span: 2">
					<td><input type="submit" value="update"></td>
					<td><a href="/logincontroller/showlogin">Home</a></td>		
				</tr>

			</table>
			
		</form:form>
		</div>
</body>
</html>