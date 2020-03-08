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
		$('form[id="recoveryId"]').validate({
			rules : {
				clientId : {
					required : true,
					email : true,
					maxlength : 35
				}
			},
			messages : {
				clientId : 'Please enter email Id',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body bgcolor="cyan">
	
	<div class="" id=""
		style="background: none repeat-x scroll 4px 3px #6E7B58;
		 left: -900px; width: 380px; text-align:left;border:10px;
		  height: 100%; position: fixed; opacity: 100;
		   filter: alpha(opacity = 60); z-index: 1000; 
		   box-shadow: 0 0 15px black; border-radius: 20px;
		    margin-top: 5%; border-color: white;outline: none;
		    padding: 20px;padding-top: 30px;float:left;position: inherit;">
		    <h1>Password Recovery</h1>
	<form:form id="recoveryId" method="POST" action="forgotpassword" modelAttribute="forgotcmd">
		<table>
			${emailstatus}
			<tr>
				<td>User Email</td>
				<td><form:input path="clientId" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="Update" size="15px" style="width: 100px;border-radius: 15px;border: none;padding: 5px;"/></td>
			</tr>
			<tr>
				<td><a href="/logincontroller//showlogin">Home</a></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>