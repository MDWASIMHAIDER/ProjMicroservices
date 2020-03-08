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
		$('form[id="signupId"]').validate({
			rules : {
				clientId : {
					required : true,
					email : true,
					maxlength : 35
				},
				clientPassword : 'required'
			},
			messages : {
				clientId : 'Please enter valid email',
				clientPassword: 'please enter password'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
  <div>
	<div style="width: 100%;height: 20%;text-align: center;background-color:#6E7B58 ;border: solid black;position: inherit;">
		<!-- <marquee direction="right" bgcolor="#6E7B58" height="30px"
                             behaviour="scroll" loop="infinite" scrolldelay="100" onmouseover="this.stop();"
                             onmouseout="this.start();"><h1>Welcome to Automated Toll Plaza System</h1>
							 </marquee> -->
		<h1>Welcome to Automated Toll Plaza System</h1>
		
	</div>
	<div style="height: 60%">
	<div id="leftbox" style="float: left; height: 100%">
		<h1>Slider
		<p>srddgjjjjjjjjjjjfdfgggggg<br>
		gfdggggggggggggghhjjkkhfg<br>
		gfhmhghgjhj</p>
		</h1>
	</div>
	 <div class="" id=""
		style="background: none repeat-x scroll 4px 3px #6E7B58;
		 left: 900px; width: 380px; text-align:left;border:10px;
		  height: 100%; position: fixed; opacity: 100;
		   filter: alpha(opacity = 60); z-index: 1000; 
		   box-shadow: 0 0 15px black; border-radius: 20px;
		    margin-top: 5%; border-color: white;outline: none;
		    padding: 20px;padding-top: 30px;float:right;position: inherit;">
		<h1>Login &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/adminController/admin" style="text-decoration: none;">Admin</a></h1>
		<form:form id="signupId" modelAttribute="logincmd" method="POST" action="loginurl">
			<c:choose>
				<c:when test="${empty locked}">
					
				</c:when>
				<c:otherwise>
					${locked }
				</c:otherwise>
			</c:choose>
			<table>
				
				<tr>
					<td>User Id</td>
					<td><form:input path="clientId" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;font-size:14px;outline:none;"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="clientPassword" size="30px" cssStyle="border-radius:15px;border:none;height:30px;overflow:hidden;outline:none;" /></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" size="15px" style="width: 100px;border-radius: 15px;border: none;padding: 5px;"/></td>
				</tr>
				<tr>
					<td><a href="/forgoturl/forgotpage" style="text-decoration: none">Forgot Password</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/signupcontroller/signup" style="text-decoration: none">SignUp</a></td>
				</tr>
			</table>
		</form:form>
	</div>
	
	</div>
	<!-- <div style="width: 100%;height: 10%; text-align: center;border: solid black;background-color:#6E7B58;">
		<h1>Footer</h1>
		<footer><h1>&copy;</h1></footer>
	</div> -->
	</div> 

</body>
</html>