<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="css/register.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="regNavPages.jsp" />
		
		<h1 style="text-align: center">Login</h1>
		
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
			<form action="login" method="POST">
				<input type="text" id="email" name="email" placeholder="Email address">
				<input type="text" id="pwd" name="pwd" placeholder="Password">
				
				<input type="submit" value="Submit">
				
			</form>
		</div>

		<jsp:include page="footer.jsp"/>
	</body>
</html>