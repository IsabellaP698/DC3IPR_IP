<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Register</title>
		<link href="css/register.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="regNavPages.jsp" />
		
		<a href="welcome">
			<img id=backArrow src = "img/backArrow.png">
		</a>
		
		<h1 style="text-align: center">Register</h1>
		
		<div class="formContainer">
		
		<div id=error>
							<%ArrayList<String> errors =  (ArrayList<String>)request.getAttribute("errors");
								if(!errors.isEmpty()) {%>
									<ul>
								<%
									for(String error: errors){%>
					
									<li><%=error%></li>
								<%}%>
							</ul>
							<%}%>
							</div>
			<form action="/register" method="POST">
				<input type="text" onkeypress="return ((event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || event.charCode == 8 || event.charCode == 32 || (event.charCode >= 48 && event.charCode <= 57));" id="fullname" name="fullname" placeholder="Full name">
				<input type="text" id="email" name="email" placeholder="Email address">
				<input type="text" id="pwd" name="pwd" placeholder="Password">
				<select id="isAdmin" name="isAdmin">
  					<option value="" disabled selected>Are You An Admin?</option>
  					<option value="y">Y</option>
  					<option value="n">N</option>
				</select>
				
				<br>
				<br>
				
				<select id="role" name="role">
  					<option value="" disabled selected>Your Role...</option>
  					<option value="Software Engineer">Software Engineer</option>
  					<option value="Scrum Master">Scrum Master</option>
				</select>
				
				<select id="type1" name="type1">
  					<option value="" disabled selected>Preferred Course Type...</option>
  					<option value="aws">AWS</option>
  					<option value="azure">Azure</option>
  					<option value="softSkills">Soft Skills</option>
				</select>
				
				<input type="submit" value="Submit">
				
			</form>
		</div>

		<jsp:include page="footer.jsp"/>
	</body>
</html>